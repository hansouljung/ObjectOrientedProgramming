
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordSearch {
    private static final String usage = "usage: java WordSearch [-h] [-v] [#threads] [#puzzles] [puzzleFile]...";
    
    public WordSearch(List<String> args) 
    {
        // Validate the command line arguments
        if (args.size() > 0 && args.get(0).equals("-h")) 
        {
            System.out.println(usage);
            System.exit(0);
        }
        if (args.size() > 0 && args.get(0).equals("-v")) {
            verbose = true;
            args.remove(0);
        } else {
            verbose = false;
        }
        int threads = 0;
        try {
            threads = Integer.parseInt(args.get(0));
            args.remove(0);
        } catch (Exception e) {
            System.err.println("Error: Invalid number of threads\n" + usage);
            System.exit(-1);
        }
        NUM_THREADS = threads;
        int numPuzzles = 0;
        try {
            numPuzzles = Integer.parseInt(args.get(0));
            args.remove(0);
        } catch (Exception e) {
            System.err.println("Error: Invalid number of puzzles\n" + usage);
            System.exit(-1);
        }

        // Load the puzzles!
        for (String puzzleName : args) {
            try (BufferedReader br = new BufferedReader(new FileReader(puzzleName))) {
                puzzles.add(new Puzzle(puzzleName, br));
            } catch (IOException e) {
                System.err.println("Unable to load puzzle " + puzzleName);
            }
        }

        // Verify all puzzles loaded successfully
        if (puzzles.size() != args.size())
            System.exit(-3);

        // Delete or duplicate puzzles to get the right number
        if (numPuzzles < puzzles.size())
            puzzles.subList(numPuzzles, puzzles.size()).clear();
        else if (numPuzzles > puzzles.size()) {
            for (int i = puzzles.size(); i < numPuzzles; ++i)
                puzzles.add(puzzles.get(i % puzzles.size()));
        }
        NUM_PUZZLES = puzzles.size();
    }
    
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    // Modify THIS method to divide up the puzzles among your threads!
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public void solve()
    {
        System.err.println("\n" + NUM_PUZZLES + " puzzles with " + NUM_THREADS + " threads");

        Thread thread = new Thread();

        for (int i = 0; i < NUM_THREADS; i ++)
        {
            final int threadID = i;
            int firstPuzzle = threadID * (NUM_PUZZLES / NUM_THREADS);
            int lastPuzzle = (threadID + 1) * (NUM_PUZZLES / NUM_THREADS);
            thread = new Thread(() -> solve(threadID, firstPuzzle, lastPuzzle, new boolean[NUM_PUZZLES]));
            thread.start();
        }

        for (int i = 0; i < NUM_THREADS; i ++)
        {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    public void solve(int threadID, int firstPuzzle, int lastPuzzle, boolean[] puzzleDone) {
        System.err.println("Thread " + threadID + ": " + firstPuzzle + "-" + (lastPuzzle-1));
        for (int i = firstPuzzle; i < lastPuzzle; ++i) {
            Puzzle p = puzzles.get(i);
            Solver solver = new Solver(p);
            for (String word : p.getWords()) {
                try {
                    Solution s = solver.solve(word);
                    if (s == null) 
                        System.err.println("#### Failed to solve " + p.name() + " for '" + word + "'");
                    else {
                        synchronized (solutions) {
                            solutions.add(s);
                        }
                    }
                } catch (Exception e) {
                    System.err.println("#### Exception solving " + p.name() + " for " + word + ": " + e.getMessage());
                }
            }
        }
    }

    public void printSolutions() {
        for (Solution s : solutions) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) 
    {
        WordSearch ws = new WordSearch(new LinkedList<>(Arrays.asList(args)));
        ws.solve();
        if (ws.verbose) 
        {
            ws.printSolutions();
        }
    }

    public final int NUM_THREADS;
    public final int NUM_PUZZLES;
    public final boolean verbose;

    private List<Puzzle> puzzles = new ArrayList<>();
    private SortedSet<Solution> solutions = new TreeSet<>();
}
