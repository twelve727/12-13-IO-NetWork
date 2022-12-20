package edu.kh.op.practice; //gh

import java.util.Scanner;

public class OperatorPractice {
	
	/*public void practice1() {
		
		Scanner sc	= new Scanner(System.in);
		System.out.print( "인원 수 : ");
		int input = sc.nextInt();
		
		System.out.print( "사탕 개수 : ");
		int candy = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + candy / input );
		System.out.println("남는 사탕 개수 : " + candy % input  );
		
		
	} */
	
	/*public void practice2() {
		Scanner sc	= new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.next(); // 다 실행구문 받아야하니까 넣는거
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int classroom = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		
		System.out.print("성별 : ");
		String gender = sc.next();
		
		System.out.print("성적 : ");
		double score = sc.nextDouble(); // 여기까지하면 사용자한테 값은 다 받을 수 있음
		
		//사용자가 입력한 값을 사용하게 정리하는거
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.", 
				grade, classroom, number, name, gender, score);
		
		
		
	} */
	
	
	
	public void practice3() {
		Scanner sc	= new Scanner(System.in);
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();	
				
		System.out.print("영어 : ");
		int eng = sc.nextInt();
			
		System.out.print("수학 : ");
		 int math = sc.nextInt();	
		
		int sum =  kor + eng + math; //합계
		double avg = sum / 3.0; //평균
		
		System.out.println("합계 : " + sum);
		System.out.printf("평균 : %.1f" , avg);
		
		//세 과목의 점수와 평균을 가지고 합격 여부를 처리하는데 , 삼항연산자 사용
		//세 과목 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격, &&사용
		//아니라면 부합격을 출력하세요.
		
		boolean result = (kor >= 40) && (eng >= 40)
				&& (math >= 40)&& (avg >= 60); //조건이 네개임 각 과목이 40이넘는지랑 평균이 60넘는지
		
		System.out.println(); // 불합격을 맨밑에 오게하려고 미관상
		System.out.println(result ? "합격" : "불합격");
						// 조건식 ? 식1 : 식2
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}