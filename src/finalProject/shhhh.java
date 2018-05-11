package finalProject;


public class shhhh {

	public static void main(String[] args) {
		tryIt obj = new So();
		//obj.show();

		int[][] nums = new int[4][5];
		
		for(int row = 0; row<nums.length; row++) {
			for(int col = 0; col<nums[0].length; col++) {
				nums[row][col] = row+col;
				System.out.print(nums[row][col]);
			}
			System.out.println(nums[row]);
		}
	}

}
