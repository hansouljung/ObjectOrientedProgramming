import java.util.Objects;

public class Solution implements Comparable<Solution> 
{ 
    public Solution(String name, String word, int x, int y, Direction direction)
     {
        this.name = name;
        this.word = word;
        this.x = x;
        this.y = y;;
        this.direction = direction;
    }

    @Override
    public int compareTo(Solution otherSolution) 
    {
        int compareName = this.name.compareTo(otherSolution.name);
        if (compareName != 0) {
            return compareName;
        } else {
            return this.word.compareTo(otherSolution.word);
        }
    }

    @Override 
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Solution solution = (Solution) o;
        return x == solution.x &&
                y == solution.y &&
                Objects.equals(name, solution.name) &&
                Objects.equals(word, solution.word) &&
                direction == solution.direction;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(name, word, x, y, direction);
    }

    @Override
    public String toString() 
    {
        return "In " + name + ": " + word + " found at (" + x + "," + y + "," + direction + ")";
    }

    private String name;
    private String word;
    private int x;
    private int y;
    private Direction direction;
}