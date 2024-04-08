package arrays;

public class MajorityElementII {

    public int repeatedNumber(int[] A) {
        if (A.length < 2)
            return A[0];

        int firstMajorityElement = A[0], firstMajorityFreq = 1;
        int secondMajorityElement = A[1], secondMajorityFreq = 1;

        for (int i = 2; i < A.length; i++) {
            if (A[i] == firstMajorityElement)
                firstMajorityFreq++;
            else if (A[i] == secondMajorityElement)
                secondMajorityFreq++;
            else {
                // if both frequencies are 0, then we need to update both elements
                if (firstMajorityFreq == 0) {
                    firstMajorityElement = A[i];
                    firstMajorityFreq++;

                    // if second frequency is 0, then we need to update second element
                } else if (secondMajorityFreq == 0) {
                    secondMajorityElement = A[i];
                    secondMajorityFreq--;

                } else {
                    firstMajorityFreq--;
                    secondMajorityFreq--;
                    // if both frequencies are not 0, then we need to decrease both frequencies

                }

            }

        }

        firstMajorityFreq = 0;
        secondMajorityFreq = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == firstMajorityElement) {
                firstMajorityFreq++;

            } else if (A[i] == secondMajorityElement) {
                secondMajorityFreq++;
            }

        }

        if (firstMajorityFreq > A.length / 3) {
            return firstMajorityElement;

        } else if (secondMajorityFreq > A.length / 3) {
            return secondMajorityElement;
        }

        return -1;

    }

    public static void main(String[] args) {
        MajorityElementII majorityElement = new MajorityElementII();
        int[] arr = { 1, 2, 3, 1, 1 };
        System.out.println(majorityElement.repeatedNumber(arr));
    }
}
