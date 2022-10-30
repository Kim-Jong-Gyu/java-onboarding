package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 큰 틀의 기능
 * 1. 입력값 체크
 * 2. 닉네임을 통한 연속적인 값들이 있는 배열 생성 함수 ex) 제이엠 -> [제이 , 이엠 , 제이엠 ]
 * 3. 같은 것이 있는지 없는지 체크 기능 함수
 * 4. 같은게 있을 시 추가 되는 함수
 * 5. 결과값 반환하는 함수
 * **/

/**
 * 1. 입력값 체크 기능 함수
 * - 크루는 1명 이상 10,000명 이하이다.
 * - 이메일은 이메일 형식에 부합하며 전체길이는 11자 이상 20자 미안 -> 이메일 체크함수
 *   - 이메일 도메인은 email.com 체크 함수 -> substring
 *     - 이메일 도메인 위치 체크를 위해 @위치 찾는 함수 구현 -> indexof
 * - 닉네임 체크 함수
 *  - 한글만 있는지 체크 함수 -> 자바 정규식 사용
 *  - 1자 이상 20자 미안인지 체크 하는 함수
 * **/

/**
 * 2. 닉네임을 통한 연속적인 값들이 있는 배열 생성 함수 ex) 제이엠 -> [제이 , 이엠 , 제이엠 ]
 * - 클래스 변수 생성
 * - substring 사용
 * **/

public class Problem6 {

    private static List<String> continuousNickList = new ArrayList<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean checkCrew(List<List<String>> inputForms){
        if(inputForms.size() < 1 || inputForms.size() > 10000)
            return false;
        return true;
    }

    private static int findDomainLocation(String inputEmail){
        return inputEmail.indexOf("@");
    }
    private static boolean checkDomain(String inputEmail){
        if(findDomainLocation(inputEmail) == -1)
            return false;
        if(inputEmail.substring(findDomainLocation(inputEmail + 1)).equals("email.com"))
            return true;
        return false;
    }
    private static boolean checkEmail(String inputEmail){
        if(checkDomain(inputEmail)){
            if(inputEmail.length() < 11 || inputEmail.length() >= 20)
                return false;
            return true;
        }
        return false;
    }

    private static boolean checkKorean(String inputNick){
        String regKor = "^[ㄱ-ㅎ|가-힣]*$";
        if(inputNick.matches(regKor))
            return true;
        return false;
    }

    private static boolean checkNickLength(String inputNick){
        if(inputNick.length() < 20 && inputNick.length() >= 1)
            return true;
        return false;
    }

    private static boolean checkNick(String inputNick){
        if(checkKorean(inputNick) && checkNickLength(inputNick))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String test = "가나다라마바사";
        makeContinuousMakeNickList(test);
        System.out.println(continuousNickList);
    }

    private static void makeContinuousMakeNickList(String inputNick){
        for(int i = 0; i < inputNick.length(); i++)
        {
            for(int j = i + 2; j < inputNick.length() + 1; j++)
            {
                continuousNickList.add(inputNick.substring(i,j));
            }
        }
    }
}
