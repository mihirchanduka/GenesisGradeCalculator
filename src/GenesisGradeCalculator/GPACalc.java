package GenesisGradeCalculator;

public class GPACalc {
   private static String[] letters = { "A+", "A",  "A-", "B+", "B",  "B-", "C+", "C",  "C-", "D",  "F"  };
   private static double[] Rgrades =  {4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0.00 };
   private static double[] Agrades =  {5.33, 5.00, 4.67, 4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 1.00, 0.00 };
   private static double[] Hgrades =  {6.33, 6.00, 5.67, 5.33, 5.00, 4.67, 4.33, 4.00, 3.67, 1.00, 0.00 };

    public static double[] getGradeValues(String[] input){
        double[] arrDouble = new double[input.length];
        for(int i=0; i<input.length; i++) {
            input[i] = input[i].replaceAll("%", "");
            arrDouble[i] = Double.parseDouble(input[i]);
        }
        return arrDouble;
    }
    public static double getWeightedGPA(String[] course, String[] input){
        double[] weighted = new double[input.length];
        for(int i = 0; i < input.length; i++){

            if(course[i].contains("AP") || course[i].contains("-H") ) {
                for (int j = 0; j < letters.length; j++) {
                    if (input[i].equals(letters[j])) {
                        weighted[i] = Hgrades[j];
                    }
                }
            }
            else if (course[i].contains("-1") || course[i].contains(" 1")) {
                for (int j = 0; j < letters.length; j++) {
                    if (input[i].equals(letters[j])) {
                        weighted[i] = Agrades[j];
                    }
                }
            }
            else if(course[i].contains("PHYS ED") || course[i].contains("HEALTH")){
                for (int j = 0; j < letters.length; j++) {
                    if (input[i].equals(letters[j])) {
                        weighted[i] = Rgrades[j];
                    }
                }
            }
            else {
                    for (int j = 0; j < letters.length; j++) {
                        if (input[i].equals(letters[j])) {
                            weighted[i] = Hgrades[j];
                        }
                    }
                }
        }
        double sum = 0;
        for (double num: weighted) {
            sum += num;
        }
        double average = sum / weighted.length;
        int temp = (int)(average*100.0);
        return ((double)temp)/100.0;
    }


    public static double getUnWeightedGPA(String[] input){
        double[] unweighted = new double[input.length];
        for(int i = 0; i < input.length; i++ ){
            for(int j = 0; j < letters.length; j++){
                if(input[i].equals(letters[j])){
                    unweighted[i] = Rgrades[j];
                }
            }
        }
        double sum = 0;
        for (double num: unweighted) {
            sum += num;
        }
        double average = sum / unweighted.length;
        int temp = (int)(average*100.0);
        return ((double)temp)/100.0;
    }

}
