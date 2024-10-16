// ORM class for table 'evaluation'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Wed Oct 16 04:06:47 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class evaluation extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("model", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        evaluation.this.model = (String)value;
      }
    });
    setters.put("rmse", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        evaluation.this.rmse = (Double)value;
      }
    });
    setters.put("r2", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        evaluation.this.r2 = (Double)value;
      }
    });
    setters.put("m_check15", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        evaluation.this.m_check15 = (Double)value;
      }
    });
    setters.put("m_check30", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        evaluation.this.m_check30 = (Double)value;
      }
    });
  }
  public evaluation() {
    init0();
  }
  private String model;
  public String get_model() {
    return model;
  }
  public void set_model(String model) {
    this.model = model;
  }
  public evaluation with_model(String model) {
    this.model = model;
    return this;
  }
  private Double rmse;
  public Double get_rmse() {
    return rmse;
  }
  public void set_rmse(Double rmse) {
    this.rmse = rmse;
  }
  public evaluation with_rmse(Double rmse) {
    this.rmse = rmse;
    return this;
  }
  private Double r2;
  public Double get_r2() {
    return r2;
  }
  public void set_r2(Double r2) {
    this.r2 = r2;
  }
  public evaluation with_r2(Double r2) {
    this.r2 = r2;
    return this;
  }
  private Double m_check15;
  public Double get_m_check15() {
    return m_check15;
  }
  public void set_m_check15(Double m_check15) {
    this.m_check15 = m_check15;
  }
  public evaluation with_m_check15(Double m_check15) {
    this.m_check15 = m_check15;
    return this;
  }
  private Double m_check30;
  public Double get_m_check30() {
    return m_check30;
  }
  public void set_m_check30(Double m_check30) {
    this.m_check30 = m_check30;
  }
  public evaluation with_m_check30(Double m_check30) {
    this.m_check30 = m_check30;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof evaluation)) {
      return false;
    }
    evaluation that = (evaluation) o;
    boolean equal = true;
    equal = equal && (this.model == null ? that.model == null : this.model.equals(that.model));
    equal = equal && (this.rmse == null ? that.rmse == null : this.rmse.equals(that.rmse));
    equal = equal && (this.r2 == null ? that.r2 == null : this.r2.equals(that.r2));
    equal = equal && (this.m_check15 == null ? that.m_check15 == null : this.m_check15.equals(that.m_check15));
    equal = equal && (this.m_check30 == null ? that.m_check30 == null : this.m_check30.equals(that.m_check30));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof evaluation)) {
      return false;
    }
    evaluation that = (evaluation) o;
    boolean equal = true;
    equal = equal && (this.model == null ? that.model == null : this.model.equals(that.model));
    equal = equal && (this.rmse == null ? that.rmse == null : this.rmse.equals(that.rmse));
    equal = equal && (this.r2 == null ? that.r2 == null : this.r2.equals(that.r2));
    equal = equal && (this.m_check15 == null ? that.m_check15 == null : this.m_check15.equals(that.m_check15));
    equal = equal && (this.m_check30 == null ? that.m_check30 == null : this.m_check30.equals(that.m_check30));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.model = JdbcWritableBridge.readString(1, __dbResults);
    this.rmse = JdbcWritableBridge.readDouble(2, __dbResults);
    this.r2 = JdbcWritableBridge.readDouble(3, __dbResults);
    this.m_check15 = JdbcWritableBridge.readDouble(4, __dbResults);
    this.m_check30 = JdbcWritableBridge.readDouble(5, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.model = JdbcWritableBridge.readString(1, __dbResults);
    this.rmse = JdbcWritableBridge.readDouble(2, __dbResults);
    this.r2 = JdbcWritableBridge.readDouble(3, __dbResults);
    this.m_check15 = JdbcWritableBridge.readDouble(4, __dbResults);
    this.m_check30 = JdbcWritableBridge.readDouble(5, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(model, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(rmse, 2 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(r2, 3 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(m_check15, 4 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(m_check30, 5 + __off, 8, __dbStmt);
    return 5;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(model, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeDouble(rmse, 2 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(r2, 3 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(m_check15, 4 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(m_check30, 5 + __off, 8, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.model = null;
    } else {
    this.model = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.rmse = null;
    } else {
    this.rmse = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.r2 = null;
    } else {
    this.r2 = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.m_check15 = null;
    } else {
    this.m_check15 = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.m_check30 = null;
    } else {
    this.m_check30 = Double.valueOf(__dataIn.readDouble());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.model) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, model);
    }
    if (null == this.rmse) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.rmse);
    }
    if (null == this.r2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.r2);
    }
    if (null == this.m_check15) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.m_check15);
    }
    if (null == this.m_check30) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.m_check30);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.model) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, model);
    }
    if (null == this.rmse) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.rmse);
    }
    if (null == this.r2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.r2);
    }
    if (null == this.m_check15) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.m_check15);
    }
    if (null == this.m_check30) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.m_check30);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(model==null?"null":model, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rmse==null?"null":"" + rmse, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(r2==null?"null":"" + r2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(m_check15==null?"null":"" + m_check15, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(m_check30==null?"null":"" + m_check30, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(model==null?"null":model, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rmse==null?"null":"" + rmse, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(r2==null?"null":"" + r2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(m_check15==null?"null":"" + m_check15, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(m_check30==null?"null":"" + m_check30, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.model = null; } else {
      this.model = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rmse = null; } else {
      this.rmse = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.r2 = null; } else {
      this.r2 = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.m_check15 = null; } else {
      this.m_check15 = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.m_check30 = null; } else {
      this.m_check30 = Double.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.model = null; } else {
      this.model = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rmse = null; } else {
      this.rmse = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.r2 = null; } else {
      this.r2 = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.m_check15 = null; } else {
      this.m_check15 = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.m_check30 = null; } else {
      this.m_check30 = Double.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    evaluation o = (evaluation) super.clone();
    return o;
  }

  public void clone0(evaluation o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("model", this.model);
    __sqoop$field_map.put("rmse", this.rmse);
    __sqoop$field_map.put("r2", this.r2);
    __sqoop$field_map.put("m_check15", this.m_check15);
    __sqoop$field_map.put("m_check30", this.m_check30);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("model", this.model);
    __sqoop$field_map.put("rmse", this.rmse);
    __sqoop$field_map.put("r2", this.r2);
    __sqoop$field_map.put("m_check15", this.m_check15);
    __sqoop$field_map.put("m_check30", this.m_check30);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
