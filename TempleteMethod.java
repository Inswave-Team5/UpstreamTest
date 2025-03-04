import java.util.Scanner;

abstract class CaffeineBeverage {
    // 템플릿 메서드
    final void prepareRecipe() {
        boilWater(); // "물 끓이기"
        brew();
        pourInCup(); // "컵에 따르는 중"
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
    abstract void brew();
    abstract void addCondiments();
    // hook 메서드
    boolean customerWantsCondiments() {
        return false;
	  }
    public void boilWater() {
    	System.out.println("********************");
        System.out.println("1. 물 끓이기");
    }
    public void pourInCup() {
        System.out.println("3. 컵에 따르는 중");
    }
}


class Coffee extends CaffeineBeverage {
    public void brew() {
        System.out.println("2. 필터를 통해 커피를 우려내는 중");
    }
    public void addCondiments() {
        System.out.println("4. 추가 레시피 종료");
    }
    boolean customerWantsCondiments() {
        System.out.print("커피에 우유와 설탕을 넣어 드릴까요? (y/n) : ");
        String answer = new Scanner(System.in).nextLine().trim();
        if (answer.toLowerCase().startsWith("y")) {
        	System.out.println("우유와 설탕이 추가되었습니다.");
            return true;
        } else {
        	System.out.println("우유와 설탕을 추가하지 않았습니다.");
            return false;
        }
    }
}


class Tea extends CaffeineBeverage {
    public void brew() {
        System.out.println("2. 차를 우리는 중");
    }
    public void addCondiments() {
    	System.out.println("4. 레몬 추가 완료");
    }
    
}


public class TempleteMethod {

	public static void main(String[] args) {
		
		Coffee coffee = new Coffee();
		Tea tea = new Tea();
		
		coffee.prepareRecipe();
		tea.prepareRecipe();

	}

}
