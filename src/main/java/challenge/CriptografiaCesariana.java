package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CriptografiaCesariana implements Criptografia {

	List<Character> letras = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
	List<Character> cripts = Arrays.asList('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c');

	@Override
	public String criptografar(String texto) {
		NullEIllegal(texto);
		String palavra = texto.toLowerCase();
		List<Character> chars = new ArrayList<>();
		for (char ch : palavra.toCharArray()) {
			chars.add(ch);
		}
		try {
			StringBuilder str = new StringBuilder(palavra.replaceAll("\\d", ""));
			for (int i = 0; i < str.length(); i++) {
				if(letras.contains(str.charAt(i))) {
					chars.set(i, cripts.get(letras.indexOf(str.charAt(i))));					
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException("esse method nao esta implementado aainda");
		}
		return chars.stream().map(String::valueOf).collect(Collectors.joining());
	}

	@Override
	public String descriptografar(String texto) {
		NullEIllegal(texto);
		String palavra = texto.toLowerCase();
		List<Character> chars = new ArrayList<>();
		for (char ch : palavra.toCharArray()) {
			chars.add(ch);
		}
		try {
			StringBuilder str = new StringBuilder(palavra.replaceAll("\\d", ""));
			for (int i = 0; i < str.length(); i++) {
				if(cripts.contains(str.charAt(i))) {
					chars.set(i, letras.get(cripts.indexOf(str.charAt(i))));					
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException("esse method nao esta implementado aainda");
		}
		return chars.stream().map(String::valueOf).collect(Collectors.joining());
	}

	private void NullEIllegal(String texto) {
		if (texto.equals(null)) {
			throw new NullPointerException();
		} else if (texto.equals("")) {
			throw new IllegalArgumentException();
		}
	}
}