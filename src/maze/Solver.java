package maze;

public class Solver {
	
	
	/*
	 * This method takes the maze in the given string format,
	 * makes it into a two-dimensional character array and calls a recursive function
	 * that returns the solution
	 */
	public void solveMaze(String mazeString){
		String path = new String();
		String [] mazeRows = mazeString.split("\\r?\\n");
		char [][] maze = new char[mazeRows.length][mazeRows[0].length()];
		for (int i = 0; i < mazeRows.length; i ++){
			maze[i] = mazeRows[i].toCharArray();
		}
		boolean [][] visited = new boolean[maze.length][maze[0].length];
		path = mazeHelper(1, 1, maze, new String(), visited);
		System.out.println(path);
	}
	
	/*
	 * This is a helper function used by solveMaze to find the solution to the maze.
	 * It moves in all cardinal directions and returns the path as soon as the current element is
	 * the bottom right corner.
	 */
	public String mazeHelper(int currentRow, int currentColumn, char [][] maze, String currentPath, boolean[][] visited){
		if (currentRow >= maze.length || currentColumn >= maze[0].length || visited[currentRow][currentColumn]){
			return null;
		}
		else{
			visited[currentRow][currentColumn] = true;
		}
		if (currentRow == maze.length - 1 && currentColumn == maze[0].length - 2){
			return currentPath;
		}
		if (maze[currentRow - 1][currentColumn] != '_'){
			String northPath = mazeHelper(currentRow - 1, currentColumn, maze, currentPath + "N", visited.clone());
			if (northPath != null){
				return northPath;
			}
		}
		if (maze[currentRow][currentColumn] != '_'){
			String southPath = mazeHelper(currentRow + 1, currentColumn, maze, currentPath + "S", visited.clone());
			if (southPath != null){
				return southPath;
			}
		}
		if (maze[currentRow][currentColumn + 1] != '|'){
			String eastPath = mazeHelper(currentRow, currentColumn + 2, maze, currentPath + "E", visited.clone());
			if (eastPath != null){
				return eastPath;
			}
		}
		if (maze[currentRow][currentColumn - 1] != '|'){
			String westPath = mazeHelper(currentRow, currentColumn - 2, maze, currentPath + "W", visited.clone());
			if (westPath != null){
				return westPath;
			}
		}	
		return null;
	}
	
	public static void main(String[] args)
	{
		Solver solver = new Solver();
		solver.solveMaze(" ___________________ \n|_  |  ___     _   _|\n| | |  _|___| |_  | |\n|  _____|_  |  _|   |\n| | |  _  |  _|_  | |\n|___| | | |  _  | | |\n| |_  |  _____| | |_|\n| |___| |  _|   |_  |\n|     | |___  |_  | |\n|_| | |  _  |_| |_| |\n|___|___|_______|___|\n");
	}

}
