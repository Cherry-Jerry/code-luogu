package RecoveryTraining;

import java.io.IOException;

public class B2005 {
	public static void main(String[] args) throws IOException {
		char c = (char)System.in.read();
		StringBuilder sb = new StringBuilder();
		sb.append("  ").append(c).append("\n");
		sb.append(" ").append(c).append(c).append(c).append("\n");
		sb.append(c).append(c).append(c).append(c).append(c).append("\n");
		System.out.println(sb);
	}
}
