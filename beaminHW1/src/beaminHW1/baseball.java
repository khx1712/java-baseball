/*
* mianClass
*
* v 1.0
*
* 2019_03_27
* 
* ���۱�����
*/

package beaminHW1;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class baseball {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		do {
			int[] num_computer = getNumComputer();
			playBaseball(num_computer);
			System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
		} while(scan.nextInt() == 1); 
	}
	
	public static int[] getNumPlayer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ڸ� �Է����ּ��� : ");
		int temp = scan.nextInt();
		int[] num_player = new int[3];
		for(int i=0; i<3; i++) {
			num_player[i] = temp%10;
			temp /= 10;
		}
		return num_player;
	}
	
	public static int[] getNumComputer() {
		Random generator = new Random();	
		int cnt =0;
		int[] num_computer = new int[9];
		Arrays.fill(num_computer, -1);
		while(cnt<3) {
			int temp = generator.nextInt(9)+1;
			if(num_computer[temp-1] != -1) {
				continue;
			}
			num_computer[temp-1] = cnt;
			cnt++;
		}
		return num_computer;
	}
	
	public static void playBaseball(int[] num_computer) {
		while(true) {
			int[] num_player = getNumPlayer();
			int[] strikeBall = getStrikeBall(num_computer, num_player);
			if(strikeBall[0] == 3) {
				System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ��������");	
				break;
			}
			if(strikeBall[0] > 0) {
				System.out.print( strikeBall[0]+" ��Ʈ����ũ ");	
			}
			if(strikeBall[1] > 0) {
				System.out.print( strikeBall[1]+" ��");	
			}
			if(strikeBall[0] != 0 || strikeBall[1] != 0) {
				System.out.print("\n");
			}
		}
	}
	
	public static int[] getStrikeBall(int[] num_computer, int[] num_player) {
		int[] strikeBall = new int[2];
		for(int i=0; i<3; i++) {
			if(num_computer[num_player[i]-1] == i) {
				strikeBall[0]++;
			} else if(num_computer[num_player[i]-1] != -1) {
				strikeBall[1]++;
			}
		}
		return strikeBall;
	}
}
