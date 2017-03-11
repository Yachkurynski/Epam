package calendar;

import calendar.dateFormats.DDDDDayOfTheWeek;
import calendar.dateFormats.DDDDayOfTheWeek;
import calendar.dateFormats.DDDayOfMonth;
import calendar.dateFormats.DDayOfMonth;
import calendar.dateFormats.DateFormat;
import calendar.dateFormats.FFFNotZeroSplitSecond;
import calendar.dateFormats.FFFSplitSecond;
import calendar.dateFormats.FFNotZeroSplitSecond;
import calendar.dateFormats.FFSplitSecond;
import calendar.dateFormats.FNotZeroSplitSecond;
import calendar.dateFormats.FSplitSecond;
import calendar.dateFormats.GEra;
import calendar.dateFormats.GGEra;
import calendar.dateFormats.H12Hours;
import calendar.dateFormats.H24Hours;
import calendar.dateFormats.HH12Hours;
import calendar.dateFormats.HH24Hours;
import calendar.dateFormats.MMMMMonth;
import calendar.dateFormats.MMMMonth;
import calendar.dateFormats.MMMinutes;
import calendar.dateFormats.MMMonth;
import calendar.dateFormats.MMinutes;
import calendar.dateFormats.MMonth;
import calendar.dateFormats.SSSeconds;
import calendar.dateFormats.SSeconds;
import calendar.dateFormats.THalfOfTheDay;
import calendar.dateFormats.TTHalfOfTheDay;
import calendar.dateFormats.YYYYYYear;
import calendar.dateFormats.YYYYYear;
import calendar.dateFormats.YYYYear;
import calendar.dateFormats.YYYear;
import calendar.dateFormats.YYear;
import calendar.dateFormats.ZTimeOffset;
import calendar.dateFormats.ZZTimeOffset;
import calendar.dateFormats.ZZZTimeOffset;

/**
 * Looking needed value of date or time according to given format.
 */
public class DateBuilder {
  public DateFormat getCurrentTime() {
    DateFormat dDayOfMonth = new DDayOfMonth();
    DateFormat ddDayOfMonth = new DDDayOfMonth();
    DateFormat dddDayOfTheWeek = new DDDDayOfTheWeek();
    DateFormat ddddDayOfTheWeek = new DDDDDayOfTheWeek();

    DateFormat fSplitSec = new FSplitSecond();
    DateFormat ffSplitSec = new FFSplitSecond();
    DateFormat fffSplitSec = new FFFSplitSecond();
    DateFormat fNotZeroSplitSec = new FNotZeroSplitSecond();
    DateFormat ffNotZeroSplitSec = new FFNotZeroSplitSecond();
    DateFormat fffNotZeroSplitSec = new FFFNotZeroSplitSecond();

    DateFormat gEra = new GEra();
    DateFormat ggEra = new GGEra();

    DateFormat h12Hours = new H12Hours();
    DateFormat hh12Hours = new HH12Hours();
    DateFormat h24Hours = new H24Hours();
    DateFormat hh24Hours = new HH24Hours();

    DateFormat mMinutes = new MMinutes();
    DateFormat mmMinutes = new MMMinutes();

    DateFormat mMonths = new MMonth();
    DateFormat mmMonths = new MMMonth();
    DateFormat mmmMonths = new MMMMonth();
    DateFormat mmmmMonths = new MMMMMonth();

    DateFormat sSecond = new SSeconds();
    DateFormat ssSecond = new SSSeconds();

    DateFormat tHalfOfTheDay = new THalfOfTheDay();
    DateFormat ttHalfOfTheDay = new TTHalfOfTheDay();

    DateFormat yYear = new YYear();
    DateFormat yyYear = new YYYear();
    DateFormat yyyYear = new YYYYear();
    DateFormat yyyyYear = new YYYYYear();
    DateFormat yyyyyYear = new YYYYYYear();

    DateFormat zTimeOffset = new ZTimeOffset();
    DateFormat zzTimeOffset = new ZZTimeOffset();
    DateFormat zzzTimeOffset = new ZZZTimeOffset();

    dDayOfMonth.setNextFormat(ddDayOfMonth);
    ddDayOfMonth.setNextFormat(dddDayOfTheWeek);
    dddDayOfTheWeek.setNextFormat(ddddDayOfTheWeek);
    ddddDayOfTheWeek.setNextFormat(fSplitSec);

    fSplitSec.setNextFormat(ffSplitSec);
    ffSplitSec.setNextFormat(fffSplitSec);
    fffSplitSec.setNextFormat(fNotZeroSplitSec);
    fNotZeroSplitSec.setNextFormat(ffNotZeroSplitSec);
    ffNotZeroSplitSec.setNextFormat(fffNotZeroSplitSec);
    fffNotZeroSplitSec.setNextFormat(gEra);

    gEra.setNextFormat(ggEra);
    ggEra.setNextFormat(h12Hours);

    h12Hours.setNextFormat(hh12Hours);
    hh12Hours.setNextFormat(h24Hours);
    h24Hours.setNextFormat(hh24Hours);
    hh24Hours.setNextFormat(mMinutes);

    mMinutes.setNextFormat(mmMinutes);
    mmMinutes.setNextFormat(mMonths);

    mMonths.setNextFormat(mmMonths);
    mmMonths.setNextFormat(mmmMonths);
    mmmMonths.setNextFormat(mmmmMonths);
    mmmmMonths.setNextFormat(sSecond);

    sSecond.setNextFormat(ssSecond);
    ssSecond.setNextFormat(tHalfOfTheDay);

    tHalfOfTheDay.setNextFormat(ttHalfOfTheDay);
    ttHalfOfTheDay.setNextFormat(yYear);

    yYear.setNextFormat(yyYear);
    yyYear.setNextFormat(yyyYear);
    yyyYear.setNextFormat(yyyyYear);
    yyyyYear.setNextFormat(yyyyyYear);
    yyyyyYear.setNextFormat(zTimeOffset);

    zTimeOffset.setNextFormat(zzTimeOffset);
    zzTimeOffset.setNextFormat(zzzTimeOffset);

    return dDayOfMonth;
  }
}
