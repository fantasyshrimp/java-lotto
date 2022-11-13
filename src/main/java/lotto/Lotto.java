package lotto;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자입니다.");
        }
    }
    private void validateLotto(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (countSameNumber(numbers,number) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
        }
    }

    private int countSameNumber(List<Integer> numbers, int standardNumber) {
        int count = 0;
        for (int number : numbers) {
            if (number == standardNumber) {
                count++;
            }
        }
        return count;
    }
}


class UserInput {

    static public void requestPayment() {
        String userInput = Console.readLine();
        isNumeric(userInput);
    }

    static public void requestWinningLottoNumber() {

    }

    static public void requestBonusNumber() {

    }



    private static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 이루어져 있습니다.");
        }
    }
    private static void isInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");
        }
    }
}




