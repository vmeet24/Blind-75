class Solution {
    public String nextClosestTime(String time) {
        String[] timeSplit = time.split(":");
        String hours = timeSplit[0];
        String min = timeSplit[1];
        Set<Character> digits = new HashSet<>();
        digits.add(hours.charAt(0));
        digits.add(hours.charAt(1));
        digits.add(min.charAt(0));
        digits.add(min.charAt(1));
        Integer hourInInt = Integer.parseInt(hours);
        Integer minInInt = Integer.parseInt(min);
        boolean flag = false;

        while (minInInt <= 60) {
            minInInt++;
            if (minInInt == 60) {
                flag = true;
                minInInt = 0;
            }
            String t = minInInt.toString();
            if (t.length() == 1) {
                if (digits.contains(t.charAt(0)) && digits.contains('0')) {
                    min = "0" + t;
                    break;
                }
            } else if (minInInt.toString().length() == 2) {
                if (digits.contains(t.charAt(0)) && digits.contains(t.charAt(1))) {
                    min = t;
                    break;
                }
            }
        }

        if (flag) {
            while (hourInInt <= 60) {
                hourInInt++;
                if (hourInInt == 24) {
                    hourInInt = 0;
                }
                String t = hourInInt.toString();
                if (t.length() == 1) {
                    if (digits.contains(t.charAt(0)) && digits.contains('0')) {
                        return "0" + t + ":" + min;
                    }
                } else if (t.toString().length() == 2) {
                    if (digits.contains(t.charAt(0)) && digits.contains(t.charAt(1))) {
                        return t + ":" + min;
                    }
                }

            }
        }

        return hours + ":" + min;
    }
}