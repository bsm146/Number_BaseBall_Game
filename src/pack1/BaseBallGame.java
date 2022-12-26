package pack1;

import java.util.Scanner;

public class BaseBallGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// 숫자 생성
		
		int[] baseNum = new int[4];
		int[] answerNum = new int[4];
		int index = 0;
		
		boolean duplicate = false;
		
		while (index <= 3) {
			
			int randomNum = (int) (Math.random() * 6 + 1);
			
			for (int i = 0; i < baseNum.length; i++) {
				
				if (randomNum == baseNum[i]) {
					duplicate = true;
					break;
				}
				else {
					duplicate = false;
				}
			}
			
			if (!duplicate) {
				
				baseNum[index] = randomNum;
				index++;
			}
		}
		
		System.out.print("정답 : ");
		for (int i = 0; i < baseNum.length; i++) {
			
			System.out.print(baseNum[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		// 시도
		
		int chance = 1;
		
		while (true) {
			
			int ballCount = 0;
			int strikeCount = 0;
			
			System.out.print(chance + "번째 기회 : ");
			String answer = scanner.nextLine();
			
			// 입력받은 4자리 숫자 answerNum에 넣기
			for (int i = 0; i < answerNum.length; i++) {
				
				answerNum[i] = Character.getNumericValue(answer.charAt(i));
			}
			
			// 정답, 시도하는 숫자 출력
			System.out.print("정답 : ");
			for (int i = 0; i < baseNum.length; i++) {
				System.out.print(baseNum[i] + " ");
			}
			System.out.println();
			System.out.print("도전 : ");
			for (int i = 0; i < answerNum.length; i++) {
				System.out.print(answerNum[i] + " ");
			}
			System.out.println();
			
			if (baseNum[0] == answerNum[0] &&
				baseNum[1] == answerNum[1] &&
				baseNum[2] == answerNum[2] &&
				baseNum[3] == answerNum[3]) {
				
				System.out.println("4 S");
				System.out.println(chance + "번만에 정답");
				return;
			}
			
			// 숫자 비교
			for (int i = 0; i < baseNum.length; i++) {
				
				for (int j = 0; j < answerNum.length; j++) {
					
					// S
					if (baseNum[i] == answerNum[i]) {
						strikeCount++;
						break;
					}
					
					// B
					if (baseNum[i] == answerNum[j]) {
						ballCount++;
						break;
					}
				}
			}
			
			// S
			if (strikeCount > 0) {
				System.out.print(strikeCount + " S ");
			}
			
			// B
			if (ballCount > 0) {
				System.out.print(ballCount + " B");
			}
			System.out.println();
			
			chance++;
			System.out.println();
		}
	}
}