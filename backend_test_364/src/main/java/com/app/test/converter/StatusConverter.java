package com.app.test.converter;

import com.app.test.enums.Status;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status status) {
        return status != null ? status.ordinal() : null;
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return Status.getStatus(dbData);
    }
}
