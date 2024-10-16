// ORM class for table 'route_data'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Mon Oct 14 17:22:52 MSK 2024
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

public class route_data extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("origin", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        route_data.this.origin = (String)value;
      }
    });
    setters.put("dest", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        route_data.this.dest = (String)value;
      }
    });
    setters.put("origin_city", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        route_data.this.origin_city = (String)value;
      }
    });
    setters.put("dest_city", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        route_data.this.dest_city = (String)value;
      }
    });
    setters.put("route_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        route_data.this.route_id = (Integer)value;
      }
    });
    setters.put("most_common_distance", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        route_data.this.most_common_distance = (Double)value;
      }
    });
  }
  public route_data() {
    init0();
  }
  private String origin;
  public String get_origin() {
    return origin;
  }
  public void set_origin(String origin) {
    this.origin = origin;
  }
  public route_data with_origin(String origin) {
    this.origin = origin;
    return this;
  }
  private String dest;
  public String get_dest() {
    return dest;
  }
  public void set_dest(String dest) {
    this.dest = dest;
  }
  public route_data with_dest(String dest) {
    this.dest = dest;
    return this;
  }
  private String origin_city;
  public String get_origin_city() {
    return origin_city;
  }
  public void set_origin_city(String origin_city) {
    this.origin_city = origin_city;
  }
  public route_data with_origin_city(String origin_city) {
    this.origin_city = origin_city;
    return this;
  }
  private String dest_city;
  public String get_dest_city() {
    return dest_city;
  }
  public void set_dest_city(String dest_city) {
    this.dest_city = dest_city;
  }
  public route_data with_dest_city(String dest_city) {
    this.dest_city = dest_city;
    return this;
  }
  private Integer route_id;
  public Integer get_route_id() {
    return route_id;
  }
  public void set_route_id(Integer route_id) {
    this.route_id = route_id;
  }
  public route_data with_route_id(Integer route_id) {
    this.route_id = route_id;
    return this;
  }
  private Double most_common_distance;
  public Double get_most_common_distance() {
    return most_common_distance;
  }
  public void set_most_common_distance(Double most_common_distance) {
    this.most_common_distance = most_common_distance;
  }
  public route_data with_most_common_distance(Double most_common_distance) {
    this.most_common_distance = most_common_distance;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof route_data)) {
      return false;
    }
    route_data that = (route_data) o;
    boolean equal = true;
    equal = equal && (this.origin == null ? that.origin == null : this.origin.equals(that.origin));
    equal = equal && (this.dest == null ? that.dest == null : this.dest.equals(that.dest));
    equal = equal && (this.origin_city == null ? that.origin_city == null : this.origin_city.equals(that.origin_city));
    equal = equal && (this.dest_city == null ? that.dest_city == null : this.dest_city.equals(that.dest_city));
    equal = equal && (this.route_id == null ? that.route_id == null : this.route_id.equals(that.route_id));
    equal = equal && (this.most_common_distance == null ? that.most_common_distance == null : this.most_common_distance.equals(that.most_common_distance));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof route_data)) {
      return false;
    }
    route_data that = (route_data) o;
    boolean equal = true;
    equal = equal && (this.origin == null ? that.origin == null : this.origin.equals(that.origin));
    equal = equal && (this.dest == null ? that.dest == null : this.dest.equals(that.dest));
    equal = equal && (this.origin_city == null ? that.origin_city == null : this.origin_city.equals(that.origin_city));
    equal = equal && (this.dest_city == null ? that.dest_city == null : this.dest_city.equals(that.dest_city));
    equal = equal && (this.route_id == null ? that.route_id == null : this.route_id.equals(that.route_id));
    equal = equal && (this.most_common_distance == null ? that.most_common_distance == null : this.most_common_distance.equals(that.most_common_distance));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.origin = JdbcWritableBridge.readString(1, __dbResults);
    this.dest = JdbcWritableBridge.readString(2, __dbResults);
    this.origin_city = JdbcWritableBridge.readString(3, __dbResults);
    this.dest_city = JdbcWritableBridge.readString(4, __dbResults);
    this.route_id = JdbcWritableBridge.readInteger(5, __dbResults);
    this.most_common_distance = JdbcWritableBridge.readDouble(6, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.origin = JdbcWritableBridge.readString(1, __dbResults);
    this.dest = JdbcWritableBridge.readString(2, __dbResults);
    this.origin_city = JdbcWritableBridge.readString(3, __dbResults);
    this.dest_city = JdbcWritableBridge.readString(4, __dbResults);
    this.route_id = JdbcWritableBridge.readInteger(5, __dbResults);
    this.most_common_distance = JdbcWritableBridge.readDouble(6, __dbResults);
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
    JdbcWritableBridge.writeString(origin, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(dest, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(origin_city, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(dest_city, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(route_id, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(most_common_distance, 6 + __off, 8, __dbStmt);
    return 6;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(origin, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(dest, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(origin_city, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(dest_city, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(route_id, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(most_common_distance, 6 + __off, 8, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.origin = null;
    } else {
    this.origin = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.dest = null;
    } else {
    this.dest = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.origin_city = null;
    } else {
    this.origin_city = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.dest_city = null;
    } else {
    this.dest_city = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.route_id = null;
    } else {
    this.route_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.most_common_distance = null;
    } else {
    this.most_common_distance = Double.valueOf(__dataIn.readDouble());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.origin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, origin);
    }
    if (null == this.dest) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dest);
    }
    if (null == this.origin_city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, origin_city);
    }
    if (null == this.dest_city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dest_city);
    }
    if (null == this.route_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.route_id);
    }
    if (null == this.most_common_distance) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.most_common_distance);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.origin) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, origin);
    }
    if (null == this.dest) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dest);
    }
    if (null == this.origin_city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, origin_city);
    }
    if (null == this.dest_city) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dest_city);
    }
    if (null == this.route_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.route_id);
    }
    if (null == this.most_common_distance) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.most_common_distance);
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
    __sb.append(FieldFormatter.escapeAndEnclose(origin==null?"null":origin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dest==null?"null":dest, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(origin_city==null?"null":origin_city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dest_city==null?"null":dest_city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(route_id==null?"null":"" + route_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(most_common_distance==null?"null":"" + most_common_distance, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(origin==null?"null":origin, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dest==null?"null":dest, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(origin_city==null?"null":origin_city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dest_city==null?"null":dest_city, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(route_id==null?"null":"" + route_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(most_common_distance==null?"null":"" + most_common_distance, delimiters));
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
    if (__cur_str.equals("null")) { this.origin = null; } else {
      this.origin = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dest = null; } else {
      this.dest = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.origin_city = null; } else {
      this.origin_city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dest_city = null; } else {
      this.dest_city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.route_id = null; } else {
      this.route_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.most_common_distance = null; } else {
      this.most_common_distance = Double.valueOf(__cur_str);
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
    if (__cur_str.equals("null")) { this.origin = null; } else {
      this.origin = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dest = null; } else {
      this.dest = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.origin_city = null; } else {
      this.origin_city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dest_city = null; } else {
      this.dest_city = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.route_id = null; } else {
      this.route_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.most_common_distance = null; } else {
      this.most_common_distance = Double.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    route_data o = (route_data) super.clone();
    return o;
  }

  public void clone0(route_data o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("origin", this.origin);
    __sqoop$field_map.put("dest", this.dest);
    __sqoop$field_map.put("origin_city", this.origin_city);
    __sqoop$field_map.put("dest_city", this.dest_city);
    __sqoop$field_map.put("route_id", this.route_id);
    __sqoop$field_map.put("most_common_distance", this.most_common_distance);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("origin", this.origin);
    __sqoop$field_map.put("dest", this.dest);
    __sqoop$field_map.put("origin_city", this.origin_city);
    __sqoop$field_map.put("dest_city", this.dest_city);
    __sqoop$field_map.put("route_id", this.route_id);
    __sqoop$field_map.put("most_common_distance", this.most_common_distance);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
