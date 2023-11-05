package cdu.gu.common.types;

import lombok.Data;

@Data
public class SelectOption<T> {
    private String key;
    private T value;
}
