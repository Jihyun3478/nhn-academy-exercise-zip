// Reference : https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%9E%90%EB%B0%94%EB%8A%94-Call-by-reference-%EA%B0%9C%EB%85%90%EC%9D%B4-%EC%97%86%EB%8B%A4-%E2%9D%93
public class ValueRefernce {
    public static void main(String[] args) {
        int var = 1; // primitive 타입
        int[] arr = { 1 }; // reference 타입

        // 변수 자체를 보냄 (call by Value)
        add_value(var);
        System.out.println(var); // 1 : 값 변화가 없음

        // 배열 자체를 보냄 (call by Reference)
        add_reference(arr);
        System.out.println(arr[0]); // 101 : 값이 변화함
    }

    static void add_value(int var_arg) { // var_arg는 var로부터 원시값을 복사하여 받은 것임
        var_arg += 100;
    }

    static void add_reference(int[] arr_arg) { // arr과 arr_arg는 하나의 데이터 동시 참조
        arr_arg[0] += 100;
    }
}