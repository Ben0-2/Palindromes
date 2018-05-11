public class Palindromes {

	public boolean isPalindrome(String string) {
		// TODO Auto-generated method stub
		char[] list = string.toCharArray();
		String string2 = "";
		String backwardsString = "";
		for (int i = 0; i < list.length; i++) {
			if (list[i] != ' ' && list[i] != '!' && list[i] != ',') {
				string2 += list[i];
			}
		}
		for (int i = list.length - 1; i >= 0; i--) {
			if (list[i] != ' ' && list[i] != '!' && list[i] != ',') {
				backwardsString += list[i];
			}
		}
		if (backwardsString.equalsIgnoreCase(string2))
			return true;
		else
			return false;

	}

}
