package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;

public class SetService {

		// Set(집합) (주머니)
		// 1. 순서를 유지하지 않는다 (인덱스가 없어서)
		// 2. 중복을 허용하지 않는다 ( null도 중복허용XX 1개만 저장가능)
	
		// Set이 중복을 확인하는 방법
	
		// 우리가 하고있는 Collection은 객체만 저장 가능
		// Set도 컬렉션이기 떄문, 당연히 객체만 저장 가능
		
		// 객체가 가지고 있는 필드값이 모두 같으면 중복으로 판단!
		
		// --> 이 때, 필드값이 모두 같은지 비교하기 위해
		// @@@ 객체에 "equals()"가 반드시 오버라이딩 되어야 함 @@@
	
		public void ex1() {
			Set<String> set = new HashSet<String>();
			
			// HashSet : Set의 대표적인 자식클래스
			// 사용조건 1 : 저장되는 객체 equals() 오버라이딩 필수
			// 사용조건 2 : 저장되는 객체 hashCode() 오버라이딩 필수
			
			// 위 우리가 사용한 <String>은 굉장히 완성도 높은 클래스로
			// 이미 equals,hashcode가 오버라이딩 되어있음
			// 대신 다른 클래스는 equals,hashcode 오버라이딩을 꼭!! 해줘야한다
			
			// 전 시간, List에 add 써준것처럼, Set도 add(String e) : 추가
			
			set.add("네이버");
			set.add("카카오");
			set.add("배민");
			set.add("쿠팡");
			set.add("배민");
			set.add("배민");
			set.add("배민");
			set.add("배민"); // 배민 더 넣어도 출력에는 배민 하나~
			set.add("null");
			set.add("null");
			set.add("null"); // null도 출력 중복 안되서 하나
			
			System.out.println(set);
			// 확인한 것 : 순서유지X / 중복X / null도 중복X
			
			// size() : 저장된 데이터의 개수 반환
			System.out.println("저장된 데이터 개수 : " + set.size());
			
			// List에서 했던것도 되돌아보자
			
			// remove(String e) // 왜 리스트처럼 인덱스가 아닌가?, Set에는 index라는 개념이 없었음
			                    // Set에 저장된 객체 중 매개변수e와 필드값이 같은 객체를 제거
								// Hash라는 단어가 포함된 Set이면 HashCode()도 같아야함
			
			System.out.println( set.remove("배민") ); // 삭제하면 true, 못지웠으면 false
			System.out.println(set);
			
			System.out.println( set.remove("당근") ); // 없는거 지워보자 못지우면 false
			System.out.println(set);
			
			// List는 index가 있어서 get()로 요소 하나 씩 얻어올 수 있었지만
			// Set은 순서가 없어서 저장된 객체 하나를 얻어올 수 있는 방법이 없다.
			// 대신, Set 전체의 데이터를 하나씩 반복적으로 얻어올 순 있다.
			// 이걸 Iterator를 사용해 얻어와 보자
			
			
			// 1. Iterator ( 반복자 )
			// 컬렉션에서 제공하는 컬렉션 객체 반복 접근자
			// ( 컬렉션에 저장된 데이터를 임의로 하나씩 반복적으로 꺼내는 역할 )
			
			// 위 set에 있던 애들을 Iterator 해보자
			Iterator<String> it = set.iterator();
			
			// set.iterator() : Set을 Iterator로 하나씩 꺼내갈 수 있는 모양으로 변환
			
			
			// iterator 다음, 왜 for이 아닌 while이여야 할까?
			// 뭘 꺼내야할지 모르니까
			
			while(it.hasNext()) { // 다음 값이 있는지 확인해주는애 hasNext , 있으면 true, 없으면 false
				
				
				// it.next() : 다음 값(객체)를 얻어옴
				// it.hasNext() : 다음에 값이 있으면 true 반환
				
				
				String temp = it.next();
				System.out.println(temp);
			}
			
			System.out.println("===========================================");
			
			
			// Iterator 까다로우니까
			// "향상된 for문" 을 사용하자!!
			
			// for( 하나씩 꺼내 저장할 변수 : 컬렉션 )
			for(String temp : set) {
				System.out.println(temp);
			}
			
			// 훨씬 간단하다
			
		}

		public void ex2() {
			
			// Hash 함수 : 입력된 단어를 지정된 길이의 문자열로 변환하는 함수(중복X)
			// ex) 입력 : 111 -> "asdfg" (5글자)
			// ex) 입력 : 12345678 -> "qwert" (5글자)
			// == 암호화에 사용
			// 일정한 길이의 랜덤값이 생성, 중복되지 않음

			// hashCode() : 필드 값이 다르면 중복되지 않는 숫자를 만드는 메서드
			// 이걸 왜 만드냐?
			// = 빠른 데이터 검색을 위해~
			// 객체가 어디에 있는지 빨리 찾음
			
			// HashSet() : 중복 없이 데이터 저장(Set)하고 데이터 검색이 빠름(Hash)
			
			Member mem1 = new Member("user01", "pass01", 30);
			Member mem2 = new Member("user01", "pass01", 30);
			Member mem3 = new Member("user01", "pass01", 30);
			
			System.out.println( mem1 == mem2 ); // false, 참조형이기 때문에 주소를 비교함
			// 얕은 복사 경우가 아니라면 다 false
			
			if( mem1.getId().equals(mem2.getId()) ); {
			 	if( mem1.getPw().equals(mem2.getPw()) ); {
			 		if( mem1.getAge() == (mem2.getAge()) ); {
			 			System.out.println("같은 객체입니다 (true) ");
			 		}
			 	}
			}
			
			
			// 매번 이렇게 비교하기 힘듬
			// == equals() 메소드 오버라이딩
			
			System.out.println("=====================");
			
			System.out.println(mem1.equals(mem2) ); // mem1 mem2 필드가 같니? equals
			// true
			System.out.println(mem1.equals(mem3) ); // mem1 mem3 필드가 같니? equals
			// false
			
			// 135열의 equals가 아닌 Member의 오버라이딩 된 equals이다. ctrl 클릭해볼것
			// 객체, 다형성, 상속 파트 철저히 복습하기
		}
	
		public void ex3() {
			
			//중복제거에 대해 더 알아보자
			
			//오버라이딩 된 equals()를 이용하여 Member를 Set에 저장
			
			// [Key point} ! 중복이 제거될까?
			
			Set<Member> memberSet = new HashSet<Member>();
			
			memberSet.add ( new Member("user01", "pass01", 30) );		
			memberSet.add ( new Member("user02", "pass02", 40) );		
			memberSet.add ( new Member("user03", "pass03", 20) );		
			memberSet.add ( new Member("user04", "pass04", 25) );		
			memberSet.add ( new Member("user04", "pass04", 25) );
			
			for( Member mem : memberSet ) {
				System.out.println(mem);
			}
			
			
			Member mem1 = new Member("user01", "pass01", 30);
			Member mem2 = new Member("user01", "pass01", 30);
			Member mem3 = new Member("user02", "pass02", 20);
			
			System.out.println(mem1.hashCode());
			System.out.println(mem2.hashCode());
			System.out.println(mem3.hashCode());
			
			// 이처럼 중복코드가 제거된다
			// 이유? Member class의 hashcode override를 해주었기 떄문에
			
			//// 로또번호 생성기까지가 set 끝@@ ///
			
			
		}
		
		public void ex4() {

			// Wrapper 클래스 : Collection <> == 안에는 객체만 들어올 수 있음
			// 기본 자료형 -> 객체로 포장하는 클래스
			// 기본자료형에 없던 추가 기능, 값(int double char 등)을 이용하고 싶을때 이용
			
			// Wrapper 클래스 종류
			/* int -> Integer
			 * double -> Double
			 * Boolean Byte Short Long Float Character
			 */
			
			 int iNum = 10;
			 double dNum = 3.14;
			 
			 // 기본자료형 -> 포장
			 Integer w1 = new Integer(iNum); // 삭제(곧 사용하지 않지만) 여기선 일단 쓰기
			 Double w2 = new Double(dNum);
			 
			 // Wrapper 클래스 활용
			 System.out.println("int 최대값 : " + w1.MAX_VALUE); // 기울어진 글씨 static
			 System.out.println("int 최소값 : " + w1.MIN_VALUE); // 기울어진 글씨 static
			 
			 System.out.println("double 최대값 : " + w1.MAX_VALUE); // 기울어진 글씨 static
			 System.out.println("double 최소값 : " + w1.MIN_VALUE); // 기울어진 글씨 static
			 
			 
			 System.out.println("=======static 방식으로 Wrapper 클래스 사용======");
			 
			 System.out.println("int 최대값 : " + Integer.MAX_VALUE); // 기울어진 글씨 static
			 System.out.println("int 최소값 : " + Integer.MIN_VALUE); // 기울어진 글씨 static
			 
			 System.out.println("double 최대값 : " + Double.MAX_VALUE); // 기울어진 글씨 static
			 System.out.println("double 최소값 : " + Double.MIN_VALUE); // 기울어진 글씨 static
			 
			//*********************************************************
			 
			// parsing : 데이터 형식을 변환 
			
			// String 데이터를 기본 자료형으로 변환
			 
			int num1 = Integer.parseInt("100");
			double num2 = Double.parseDouble("1.23456");
			
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num1 + num2); // double과 int를 더하면???
			// == 더블형에 맞춰서 더해짐. 문자열이 아님 확인
			
			//*********************************************************
			
			
		}
		
		public void ex5() {
			// Wrapper 클래스의 AutoBoxing / AutoUnBoxing
			
			Integer w1 = new Integer(100);
			
			Integer w2 = 100;
			Integer w3 = 200;
			
			// w2와100은 원래 연산이 안되어야 하지만
			// Integer는 int의 포장 형식임을 인식해준다.
			// (Integer) (int -> Integer) 자동 포장
			
			// 이거를 AutoBoxing 이라고 한다.
			
			System.out.println("w2+w3 = " + (w2+w3) );
			
			// w2 + w3 == 객체+객체인데 ==> 원래는 불가능
			// 하지만 Integer는 int의 포장 형태란걸 Java가 인식하고 있음
			// == 연산 시 포장을 자동으로 벗겨냄
			// Integer + Integer -> int + int (자동포장해제)
			
			//이를 AutoUnBoxing 이라고 한다.

			// Set 끝@@@@@@@@@@@@@@@@@@@@@@@@@@@ //
			
			
			
			
			
		}
		
		public void lotto() {
			
			// 로또 번호 생성기 Ver 2
			
			// HashSet
			// LinkedHashSet
			// TreeSet ( 오름차순 로또자동) 
			
			//Set<Integer> lotto = new HashSet<Integer>();
			//Set<Integer> lotto = new LinkedHashSet<Integer>();
			Set<Integer> lotto = new TreeSet<Integer>();
			// Integer는 equals(), HashCode() 오버라이딩 완료 상태
			
			while(lotto.size() < 6) {
				// lotto에 저장된 값이 개수가 6개 미만이면 반복한다.
				
				int random = (int)(Math.random() * 45 + 1); // 1~45 사이의 난수
				// 타입미스매치, Math 앞에 int 강제 형변환 해주어야함
				
				System.out.println(random); // 발생 순서 확인
				
				lotto.add(random);
				// int값이 자동으로 Integer로 포장(AutoBoxing)되어 lotto 추가
			}
			
			System.out.println("로또번호 : " + lotto);
			
			//HashSet을 이용하면 순서유지는X 안되지만, 중복제거는O 해준다.
			//LinkedHashSet(import 해줘야함)을 이용하면 순서유지O, 중복제거X
			//Treeset을 이용하면(우리가 이런걸 쓰고있다고 보면 됨) 자동정렬 오름차순
			
			
			// @@@@@ set 로또실습까지 끝, 이후 MAP이 중요하니 잘 캐치하기
		}
}