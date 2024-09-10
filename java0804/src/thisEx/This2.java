package thisEx;

class Car2{
	String color; // 인스턴스 변수
    String gearType;
    int door; 
    
    Car2(){
        this("white", "auto", 4); // Car(String color, string gearType, int door)를 호출
    }
    
    Car2(String color){
        this(color, "auto", 4);
    }
    
    Car2(String color, String gearType, int door){
        this.color = color; 
        this.gearType = gearType;
        this.door = door;
    }
}
/* 
 * this()는 같은 클래스의 다른 생성자를 호출할 때 사용한다. 위 코드의 Car() 생성자와 Car(String color) 생성자는
 * this()를 통해 모두 Car(String color, String gearType, int door) 생성자를 호출하고 있는 것이다.
*/