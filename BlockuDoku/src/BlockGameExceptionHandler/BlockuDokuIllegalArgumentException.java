package BlockGameExceptionHandler;

public class BlockuDokuIllegalArgumentException extends IllegalArgumentException{

	public BlockuDokuIllegalArgumentException(ErrorCode code) {
		System.out.println(code.toString());
	}
}
