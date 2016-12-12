package tpe.testate.crypter;

public class CrypterImpl implements Crypter {

	/**
	 * Verschlüsselt den gegebenen Text. Enthält die Eingabe Großbuchstaben, so
	 * werden diese in Kleinbuchstaben umgewandelt. Ungültige Zeichen werden
	 * ignoriert und nicht in den verschlüsselten Text übernommen.
	 *
	 * @param input
	 *            Text, der verschlüsselt werden soll.
	 * @return Verschlüsselter Text.
	 */
	@Override
	public String encrypt(String input) {

		String lowerC = input.toLowerCase();
		String enString = "";
		char c = ' ';

		if (lowerC.equals(""))
			return "";

		for (int i = 0; i < lowerC.length(); i++) {

			if (!(lowerC.charAt(i) >= 'a' && lowerC.charAt(i) <= 'z'
					|| lowerC.charAt(i) >= '0' && lowerC.charAt(i) <= '9' || lowerC.charAt(i) == ' '))
				i++;
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
		//System.out.println(enString);
		return enString;
	}

	/**
	 * Entschlüsselt den gegebenen Text. Enthält die Eingabe Großbuchstaben,
	 * oder andere ungültige Zeichen, so wirft die Methode eine Ausnahme.
	 *
	 * @param input
	 *            Text, der entschlüsselt werden soll.
	 * @return Entschlüsselter Text.
	 * @throws IllegalArgumentException
	 *             Wird geworfen, wenn die Eingabe ungültige Zeichen
	 *             (Großbuchstaben) enthält.
	 */
	@Override
	public String decrypt(String input) throws IllegalArgumentException {

		for (int i = 0; i < input.length(); i++)
			if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || input.charAt(i) >= '0' && input.charAt(i) <= '9'
					|| input.charAt(i) == ' '))
				throw new IllegalArgumentException();

		return encrypt(input);
	}
}