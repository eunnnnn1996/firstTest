package kr.s08.score;

//사용자정의 예외처리 클래스

public class ScoreValueException extends Exception{
	public ScoreValueException(String message) {
		super(message);
	}
}
