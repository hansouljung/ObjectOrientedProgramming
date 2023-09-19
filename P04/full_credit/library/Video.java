//modified #1
/*
package library;

import java.time.Duration;

public class Video extends Publication {
    private Duration runtime;

    public Video(String title, String author, int copyright, int runtime) {
        super(title, author, copyright);
        if (runtime <= 0) {
            throw new InvalidRuntimeException(title, runtime);
        }
        this.runtime = Duration.ofMinutes(runtime);
    }

    @Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(super.toString()); // Add the parent's toString
	    sb.append(", runtime ");
	    sb.append(runtime.toMinutes());
	    sb.append(" minutes");
	    return sb.toString();
	}

    
    public static class InvalidRuntimeException extends ArithmeticException {
        public InvalidRuntimeException(String title, int runtime) {
            super(title + " has invalid runtime " + runtime);
        }
    }
}
*/
package library;

import java.time.Duration;

/**
 * Represents a library that stores a collection of publications.
 */

public class Video extends Publication {
    private Duration runtime;


    /**
     * Initializes a new video with the given title, author, copyright year, and runtime.
     *
     * @param title     The title of the video.
     * @param author    The director or creator of the video.
     * @param copyright The copyright year of the video.
     * @param runtime   The runtime of the video in minutes.
     * @throws InvalidRuntimeException If the runtime is less than or equal to zero.
     */

    public Video(String title, String author, int copyright, int runtime) {
        super(title, author, copyright);
        if (runtime <= 0) {
            throw new InvalidRuntimeException(title, runtime);
        }
        this.runtime = Duration.ofMinutes(runtime);
    }

    /**
     * Returns a string representation of the video, including its title, author, copyright, and runtime.
     *
     * @return The string representation of the video.
     */

    
    @Override
	public String toString() {
		String runtimeS = "runtime " + runtime.toMinutes() + " minutes";

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()); // Add the parent's toString
		sb.append(", ").append(runtimeS); // Append the runtime on the same line
		

		return sb.toString();
	}
	
	


  	/**
	 * checks for invalid runtime exceptions
	 */

    public static class InvalidRuntimeException extends ArithmeticException {
    	/**
		 * checks for invalid runtime exceptions
		 */
    	public InvalidRuntimeException(){
    		super();
    	}
    	/**
		 * checks for invalid runtime exceptions
		 * @param message Prints the message for when there's an error
		 */

    	
    	public InvalidRuntimeException(String message){
    		super(message);
    	}

    	/**
		 * checks for invalid runtime exceptions
		 * @param title prints the title of book or video
		 * @param runtime prints the runtime
		 */

        public InvalidRuntimeException(String title, int runtime) {
            super(title + " has invalid runtime " + runtime);
        }
    }
}
