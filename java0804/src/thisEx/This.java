package thisEx;

class Car {
    String color; // 인스턴스 변수
    String gearType;
    int door; 
    
    Car(String color, String gearType, int door){
        this.color = color; 
        this.gearType = gearType;
        this.door = door;
    }
}
/*
 * this 는 위 코드처럼 생성자의 매개변수로 선언된 변수의 이름이 인스턴스 변수와 같을 때 인스턴스 변수와 지역변수를 구분하기 위해서 사용한다.
 * Car() 생성자 안에서의 this.color는 인스턴스 변수이고, color는 매개변수로 정의된 지역변수이다.
 * static 메서드에서는 this를 사용하지 못한다.
*/