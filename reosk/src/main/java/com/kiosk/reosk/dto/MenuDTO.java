package com.kiosk.reosk.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuDTO {
	private String mcode;
    private String mname;
    private String mimgurl;
}
