package models._static;

import java.util.*;

public class AsciiArtPrinter {

	private static final Map<Character, String[]> asciiArtMap = new HashMap<>();

	static {
		asciiArtMap.put('a', new String[] {
				" ▄▄▄      ",
				"▒████▄    ",
				"▒██  ▀█▄  ",
				"░██▄▄▄▄██ ",
				" ▓█   ▓██▒",
				" ▒▒   ▓▒█░",
				"  ▒   ▒▒ ░",
				"  ░   ▒   ",
				"      ░  ░",
				"          ",
		});

		asciiArtMap.put('b', new String[] {
				" ▄▄▄▄   ",
				"▓█████▄ ",
				"▒██▒ ▄██",
				"▒██░█▀  ",
				"░▓█  ▀█▓",
				"░▒▓███▀▒",
				"▒░▒   ░ ",
				" ░    ░ ",
				" ░      ",
				"      ░ ",
		});
		asciiArtMap.put('c', new String[] {
				" ▄████▄  ",
				"▒██▀ ▀█  ",
				"▒▓█    ▄ ",
				"▒▓▓▄ ▄██▒",
				"▒ ▓███▀ ░",
				"░ ░▒ ▒  ░",
				"  ░  ▒   ",
				"░        ",
				"░ ░      ",
				"░        ",
		});
		asciiArtMap.put('d', new String[] {
				"▓█████▄ ",
				"▒██▀ ██▌",
				"░██   █▌",
				"░▓█▄   ▌",
				"░▒████▓ ",
				" ▒▒▓  ▒ ",
				" ░ ▒  ▒ ",
				" ░ ░  ░ ",
				"   ░    ",
				" ░      ",
		});
		asciiArtMap.put('e', new String[] {
				"▓█████ ",
				"▓█   ▀ ",
				"▒███   ",
				"▒▓█  ▄ ",
				"░▒████▒",
				"░░ ▒░ ░",
				" ░ ░  ░",
				"   ░   ",
				"   ░  ░",
				"       ",
		});
		asciiArtMap.put('f', new String[] {
				"  █████▒",
				"▓██   ▒ ",
				"▒████ ░ ",
				"░▓█▒  ░ ",
				"░▒█░    ",
				" ▒ ░    ",
				" ░      ",
				" ░ ░    ",
				"        ",
				"        ",
		});
		asciiArtMap.put('g', new String[] {
				"  ▄████ ",
				" ██▒ ▀█▒",
				"▒██░▄▄▄░",
				"░▓█  ██▓",
				"░▒▓███▀▒",
				" ░▒   ▒ ",
				"  ░   ░ ",
				"░ ░   ░ ",
				"      ░ ",
				"        ",
		});
		asciiArtMap.put('h', new String[] {
				" ██░ ██ ",
				"▓██░ ██▒",
				"▒██▀▀██░",
				"░▓█ ░██ ",
				"░▓█▒░██▓",
				" ▒ ░░▒░▒",
				" ▒ ░▒░ ░",
				" ░  ░░ ░",
				" ░  ░  ░",
				"        ",
		});
		asciiArtMap.put('i', new String[] {
				" ██▓",
				"▓██▒",
				"▒██▒",
				"░██░",
				"░██░",
				"░▓  ",
				" ▒ ░",
				" ▒ ░",
				" ░  ",
				"    ",
		});
		asciiArtMap.put('j', new String[] {
				" ▄▄▄██▀▀▀",
				"   ▒██   ",
				"   ░██   ",
				"▓██▄██▓  ",
				" ▓███▒   ",
				" ▒▓▒▒░   ",
				" ▒ ░▒░   ",
				" ░ ░ ░   ",
				" ░   ░   ",
				"         ",
		});
		asciiArtMap.put('k', new String[] {
				" ██ ▄█▀",
				" ██▄█▒ ",
				"▓███▄░ ",
				"▓██ █▄ ",
				"▒██▒ █▄",
				"▒ ▒▒ ▓▒",
				"░ ░▒ ▒░",
				"░ ░░ ░ ",
				"░  ░   ",
				"       ",
		});
		asciiArtMap.put('l', new String[] {
				" ██▓    ",
				"▓██▒    ",
				"▒██░    ",
				"▒██░    ",
				"░██████▒",
				"░ ▒░▓  ░",
				"░ ░ ▒  ░",
				"  ░ ░   ",
				"    ░  ░",
				"        ",
		});
		asciiArtMap.put('m', new String[] {
				" ███▄ ▄███▓",
				"▓██▒▀█▀ ██▒",
				"▓██    ▓██░",
				"▒██    ▒██ ",
				"▒██▒   ░██▒",
				"░ ▒░   ░  ░",
				"░  ░      ░",
				"░      ░   ",
				"       ░   ",
				"           ",
		});
		asciiArtMap.put('n', new String[] {
				" ███▄    █ ",
				" ██ ▀█   █ ",
				"▓██  ▀█ ██▒",
				"▓██▒  ▐▌██▒",
				"▒██░   ▓██░",
				"░ ▒░   ▒ ▒ ",
				"░ ░░   ░ ▒░",
				"   ░   ░ ░ ",
				"         ░ ",
				"           ",
		});
		asciiArtMap.put('o', new String[] {
				" ▒█████  ",
				"▒██▒  ██▒",
				"▒██░  ██▒",
				"▒██   ██░",
				"░ ████▓▒░",
				"░ ▒░▒░▒░ ",
				"  ░ ▒ ▒░ ",
				"░ ░ ░ ▒  ",
				"    ░ ░  ",
				"         ",
		});
		asciiArtMap.put('p', new String[] {
				" ██▓███  ",
				"▓██░  ██▒",
				"▓██░ ██▓▒",
				"▒██▄█▓▒ ▒",
				"▒██▒ ░  ░",
				"▒▓▒░ ░  ░",
				"░▒ ░     ",
				"░░       ",
				"         ",
				"         ",
		});
		asciiArtMap.put('q', new String[] {
				"  █████  ",
				"▒██▓  ██▒",
				"▒██▒  ██░",
				"░██  █▀ ░",
				"░▒███▒█▄ ",
				"░░ ▒▒░ ▒ ",
				" ░ ▒░  ░ ",
				"   ░   ░ ",
				"    ░    ",
				"         ",
		});
		asciiArtMap.put('r', new String[] {
				" ██▀███  ",
				"▓██ ▒ ██▒",
				"▓██ ░▄█ ▒",
				"▒██▀▀█▄  ",
				"░██▓ ▒██▒",
				"░ ▒▓ ░▒▓░",
				"  ░▒ ░ ▒░",
				"  ░░   ░ ",
				"   ░     ",
				"         ",
		});
		asciiArtMap.put('s', new String[] {
				"  ██████ ",
				"▒██    ▒ ",
				"░ ▓██▄   ",
				"  ▒   ██▒",
				"▒██████▒▒",
				"▒ ▒▓▒ ▒ ░",
				"░ ░▒  ░ ░",
				"░  ░  ░  ",
				"      ░  ",
				"         ",
		});
		asciiArtMap.put('t', new String[] {
				"▄▄▄█████▓",
				"▓  ██▒ ▓▒",
				"▒ ▓██░ ▒░",
				"░ ▓██▓ ░ ",
				"  ▒██▒ ░ ",
				"  ▒ ░░   ",
				"    ░    ",
				"  ░      ",
				"         ",
				"         ",
		});
		asciiArtMap.put('u', new String[] {
				" █    ██ ",
				" ██  ▓██▒",
				"▓██  ▒██░",
				"▓▓█  ░██░",
				"▒▒█████▓ ",
				"░▒▓▒ ▒ ▒ ",
				"░░▒░ ░ ░ ",
				" ░░░ ░ ░ ",
				"   ░     ",
				"         ",
		});
		asciiArtMap.put('v', new String[] {
				" ██▒   █▓",
				"▓██░   █▒",
				" ▓██  █▒░",
				"  ▒██ █░░",
				"   ▒▀█░  ",
				"   ░ ▐░  ",
				"   ░ ░░  ",
				"     ░░  ",
				"      ░  ",
				"     ░   ",
		});
		asciiArtMap.put('w', new String[] {
				" █     █░",
				"▓█░ █ ░█░",
				"▒█░ █ ░█ ",
				"░█░ █ ░█ ",
				"░░██▒██▓ ",
				"░ ▓░▒ ▒  ",
				"  ▒ ░ ░  ",
				"  ░   ░  ",
				"    ░    ",
				"         ",
		});
		asciiArtMap.put('x', new String[] {
				"▒██   ██▒",
				"▒▒ █ █ ▒░",
				"░░  █   ░",
				" ░ █ █ ▒ ",
				"▒██▒ ▒██▒",
				"▒▒ ░ ░▓ ░",
				"░░   ░▒ ░",
				" ░    ░  ",
				" ░    ░  ",
				"         ",
		});
		asciiArtMap.put('y', new String[] {
				"▓██   ██▓",
				" ▒██  ██▒",
				"  ▒██ ██░",
				"  ░ ▐██▓░",
				"  ░ ██▒▓░",
				"   ██▒▒▒ ",
				" ▓██ ░▒░ ",
				" ▒ ▒ ░░  ",
				" ░ ░     ",
				" ░ ░     ",
		});
		asciiArtMap.put('z', new String[] {
				"▒███████▒",
				"▒ ▒ ▒ ▄▀░",
				"░ ▒ ▄▀▒░ ",
				"  ▄▀▒   ░",
				"▒███████▒",
				"░▒▒ ▓░▒░▒",
				"░░▒ ▒ ░ ▒",
				"░ ░ ░ ░ ░",
				"  ░ ░    ",
				"░        ",
		});
		asciiArtMap.put('.', new String[] {
				"     ",
				"     ",
				"     ",
				"     ",
				" ██▓ ",
				" ▒▓▒ ",
				" ░▒  ",
				" ░   ",
				"  ░  ",
				"  ░  ",
		});
		asciiArtMap.put(' ', new String[] {
				"     ",
				"     ",
				"     ",
				"     ",
				"     ",
				"     ",
				"     ",
				"     ",
				"     ",
				"     ",
		});
		asciiArtMap.put('!', new String[] {
				" ▐██▌ ",
				" ▐██▌ ",
				" ▐██▌ ",
				" ▓██▒ ",
				" ▒▄▄  ",
				" ░▀▀▒ ",
				" ░  ░ ",
				"    ░ ",
				" ░    ",
				"      ",
		});
	}

	public static String convertToAsciiArt(String input) {
		input = input.toLowerCase();
		StringBuilder[] result = new StringBuilder[10];

		for (int i = 0; i < 10; i++) {
			result[i] = new StringBuilder();
		}

		for (char ch : input.toCharArray()) {
			String[] art = asciiArtMap.getOrDefault(ch,
					new String[] {
							 "            ",
						 	 "            ",
						 	 "            ",
						 	 "   [??]     ",
				             "            ",
				             "            ",
				             "            ",
				             "            ",
				             "            ",
				             "            ",
					});

			for (int i = 0; i < 10; i++) {
				result[i].append(" ").append(art[i]);
			}
		}

		return String.join("\n", Arrays.stream(result).map(StringBuilder::toString).toArray(String[]::new));
	}
}
