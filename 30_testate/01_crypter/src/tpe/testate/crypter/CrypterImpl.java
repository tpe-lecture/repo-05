package tpe.testate.crypter;

public class CrypterImpl implements Crypter {

	@Override
	public String encrypt(String input) {
		// TODO Auto-generated method stub
		String lowerC = input.toLowerCase();
		String enString = "";
		char c = ' ';

		if (lowerC.equals(""))
			return "";

		for (int i = 0; i < lowerC.length(); i++) {
			// while(input.charAt(i)>122||input.charAt(i)<41)
			// i++;

			if (!(lowerC.charAt(i) >= 'a' && lowerC.charAt(i) <= 'z'
					|| lowerC.charAt(i) >= '0' && lowerC.charAt(i) <= '9' || lowerC.charAt(i) == ' '))
				throw new IllegalArgumentException();

			switch (lowerC.charAt(i)) {
			case 'e':
				c = '3';
				break;
			case '3':
				c = 'e';
				break;
			case 'l':
				c = '1';
				break;
			case '1':
				c = 'l';
				break;
			case 'o':
				c = '0';
				break;
			case '0':
				c = 'o';
				break;
			case 'a':
				c = '4';
				break;
			case '4':
				c = 'a';
				break;
			case 't':
				c = '7';
				break;
			case '7':
				c = 't';
				break;
			default:
				c = lowerC.charAt(i);
			}
			enString += c;
		}
		// System.out.println(enString);
		return enString;
	}

	@Override
	public String decrypt(String input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.equals(input.toLowerCase())) {
			return encrypt(input);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
