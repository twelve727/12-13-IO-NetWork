package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.model.vo.Member;

public class MapService {

	// Map: Key와 Value 한 쌍이 데이터가 되어 이를 모아둔 객체
	
	// Key를 모아두면 Set의 특징(중복X)
	// Value를 모아두면 List의 특징(중복O)
	
	public void ex1() {
		
		// HashMap<K,V> : Map의 자식 클래스 중 가장 대표되는 Map
		
		Map<Integer,String> map = new HashMap<Integer,String>();

		// Map.put(Integer Key, String Value) : 여기에 put(추가)
		map.put(1, "홍길동");
		map.put(2, "고길동");
		map.put(3, "김길동");
		map.put(4, "박길동");
		map.put(5, "이길동");
		map.put(6, "최길동");
		
		// Key 중복
		map.put(1, "홍홍홍"); // Key는 중복X, Value는 중복O
		// 새로 뒤에 들어온애 홍홍홍을 덮어씀
		
		// Value 중복
		map.put(7, "최길동"); // 6
		
		
		System.out.println(map); // map.toString() 오버라이딩 되어있음
	}
	
	public void ex2() {
		
		// Map 사용 예제
		
		// VO(값 저장용 객체)는 특정 데이터 묶음의 재사용이 많은 경우 주로 사용
		// --> 재사용이 적은 vo는 오히려 코드 낭비
		// --> Map을 이용해서 VO와 비슷한 코드를 작성할 수 있다
		
		//1) VO 버전
		
		Member mem = new Member();
		
		// 값 세팅
		mem.setId("user01");
		mem.setPw("pass01");
		mem.setAge(30);
		
		// 값 출력
		System.out.println( mem.getId() );
		System.out.println( mem.getPw() );
		System.out.println( mem.getAge() );
		
		
		
		
		System.out.println("=========================");
		
		// 2) Map버전
		
		Map<String, Object> map = new HashMap<String, Object>();
		// value가 Object 타입 == 어떤 객체든 Value에 들어올 수 있다.
		
		// 값 세팅
		map.put("id", "user02");
		map.put("pw", "pass02");
		map.put("age", "25"); // int -> Integer(AutoBoxing)
		// 값 출력
		System.out.println( map.get("id") );
		System.out.println( map.get("pw") );
		System.out.println( map.get("age") );
		
		System.out.println("===================");
		// Map에 저장된 데이터 순차적으로 접근하기
		
		// Map에서 Key만 모아두면, Set의 특징을 가진다고 했음
		// -> 이를 활용할 수 있도록, Map에서 KeySet() 제공
		// 즉 Key만 모아서 Set으로 반환시켜줌
		
		Set<String> set = map.keySet(); // id,pw,age가 저장된 Set을 반환
		System.out.println( set );
		
		
		//향상된 for문
		
		for( String key : set ) {
			System.out.println(map.get(key));
			// key가 반복될 떄 마다 변경
			// -> 변경된 key에 맞는 map의 value가 출력
			
		}
		
	
		// map에 저장된 데이터가 많을 때,
		// 어떤 key가 있는지 불분명 할 때,
		// map에 저장된 모든 데이터에 접근해야 할때
		// keySet() + 향상된 for문 코드 사용
		
		
		
		
	}
	
	public void ex3() {
		
		// List + Map 콜라보
		// 유저가 10명 , 유저의 아이디만 쭉 뽑아보자
		
		// K : V
		// "id : user01"
		// "id : user02"
		// "id : user03" . . . 
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// List<제한<제한>>
		// 타입제한은 둘째치고 ArrayList 객체를 생성한것이 주요포인트
		for( int i = 0; i < 10; i++) {
			//Map 생성 시작
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id","user0"+i);
			map.put("pw","user0"+i);
			
			// Map을 List에 추가
			list.add(map);
		}
		
		// for문 종료시점에 List에는 10개의 Map객체 추가
		
		// List에 저장된 map에서 key가 id인 경우의 value를 모두 출력
		
		// 향상된 for문으로 10명 id 뽑아오기
		
		for( Map<String, Object> temp : list) {
			System.out.println( temp.get("id") );
		}
		
		
		
		 //  @@@@@@@@@@@@ MAP 끝 //
	}
}
