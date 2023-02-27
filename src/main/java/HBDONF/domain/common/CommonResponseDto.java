package HBDONF.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommonResponseDto<T> implements Serializable  {
	private String code;
	private T payload;
	
	public CommonResponseDto (T payload) {
		this.payload = payload;
	}
}
