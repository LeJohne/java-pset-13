public class ProblemSet13 {

    public boolean groupSum(int start, int[] numbers, int target) {
        if (start < 0 || start >= numbers.length) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (groupSum(start + 1, numbers, target - numbers[start])) {
            return true;
        }
        return groupSum(start + 1, numbers, target);
    }

    public boolean groupSum6(int start, int[] numbers, int target) {
        if (start < 0 || start >= numbers.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        if (numbers[start] == 6) {
            return groupSum6(start + 1, numbers, target - numbers[start]);
        }
        if (groupSum6(start + 1, numbers, target - numbers[start])) {
            return true;
        }
        return groupSum6(start + 1, numbers, target);
    }

    public boolean groupNoAdj(int start, int[] numbers, int target) {
        if (start < 0 || start >= numbers.length) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (groupNoAdj(start + 2, numbers, target - numbers[start])) {
            return true;
        }
        return groupNoAdj(start + 1, numbers, target);
    }

    public boolean groupSum5(int start, int[] numbers, int target) {
        if (start < 0 || start >= numbers.length) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        if (numbers[start] % 5 == 0) {
            if (start < numbers.length - 1 && numbers[start + 1] == 1) {
                return groupSum5(start + 2, numbers, target - numbers[start]);
            }
            return groupSum5(start + 1, numbers, target - numbers[start]);
        }
        if (groupSum5(start + 1, numbers, target - numbers[start])) {
            return true;
        }
        return groupSum5(start + 1, numbers, target);
    }

    public boolean groupSumClump(int start, int[] numbers, int target) {
        if(start >= numbers.length || start < 0)
        {
            if(target == 0) {
                return true;
            }
            return false;
        }
        int i = start + 1;

        for(;  i < numbers.length && numbers[start] == numbers[i]; i++);
        if(groupSumClump(i, numbers, target - ((i - start) * numbers[start]))) {
            return true;
        }
        return groupSumClump(i, numbers, target);
    }

    public  boolean splitArray(int[] numbers) {
        return sidesAreEqual(numbers, 0, 0);
    }

    public  boolean sidesAreEqual(int[] numbers, int i, int balance)
    {
        if(i == numbers.length)
            return (balance == 0);
        if(sidesAreEqual(numbers, i + 1, balance + numbers[i]))
            return true;
        return sidesAreEqual(numbers, i + 1, balance - numbers[i]);
    }

    public boolean splitOdd(int[] numbers) {
        return splitOddHelper(0, numbers, 0, 0);
    }

    public boolean splitOddHelper(int start, int[] numbers, int mult, int odd) {
        if(start >= numbers.length) {
            return mult % 10 == 0 && odd % 2 == 1;
        }
        if(splitOddHelper(start+1, numbers, mult + numbers[start], odd)) {
            return true;
        }
        if(splitOddHelper(start+1, numbers, mult, odd + numbers[start])) {
            return true;
        }
        return false;
    }
}