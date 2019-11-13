package io.turntabl;

import java.util.Date;
import java.util.List;

public interface SalesDAO {
    List<SalesTO> getWeeklysales(Date date);
}
