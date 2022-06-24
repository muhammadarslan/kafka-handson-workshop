/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.kafka.handson;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Movie extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4414147756515110564L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Movie\",\"namespace\":\"com.kafka.handson\",\"fields\":[{\"name\":\"movie_id\",\"type\":\"long\"},{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"release_year\",\"type\":\"int\"},{\"name\":\"country\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Movie> ENCODER =
      new BinaryMessageEncoder<Movie>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Movie> DECODER =
      new BinaryMessageDecoder<Movie>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Movie> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Movie> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Movie> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Movie>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Movie to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Movie from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Movie instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Movie fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private long movie_id;
  private java.lang.CharSequence title;
  private int release_year;
  private java.lang.CharSequence country;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Movie() {}

  /**
   * All-args constructor.
   * @param movie_id The new value for movie_id
   * @param title The new value for title
   * @param release_year The new value for release_year
   * @param country The new value for country
   */
  public Movie(java.lang.Long movie_id, java.lang.CharSequence title, java.lang.Integer release_year, java.lang.CharSequence country) {
    this.movie_id = movie_id;
    this.title = title;
    this.release_year = release_year;
    this.country = country;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return movie_id;
    case 1: return title;
    case 2: return release_year;
    case 3: return country;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: movie_id = (java.lang.Long)value$; break;
    case 1: title = (java.lang.CharSequence)value$; break;
    case 2: release_year = (java.lang.Integer)value$; break;
    case 3: country = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'movie_id' field.
   * @return The value of the 'movie_id' field.
   */
  public long getMovieId() {
    return movie_id;
  }


  /**
   * Sets the value of the 'movie_id' field.
   * @param value the value to set.
   */
  public void setMovieId(long value) {
    this.movie_id = value;
  }

  /**
   * Gets the value of the 'title' field.
   * @return The value of the 'title' field.
   */
  public java.lang.CharSequence getTitle() {
    return title;
  }


  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(java.lang.CharSequence value) {
    this.title = value;
  }

  /**
   * Gets the value of the 'release_year' field.
   * @return The value of the 'release_year' field.
   */
  public int getReleaseYear() {
    return release_year;
  }


  /**
   * Sets the value of the 'release_year' field.
   * @param value the value to set.
   */
  public void setReleaseYear(int value) {
    this.release_year = value;
  }

  /**
   * Gets the value of the 'country' field.
   * @return The value of the 'country' field.
   */
  public java.lang.CharSequence getCountry() {
    return country;
  }


  /**
   * Sets the value of the 'country' field.
   * @param value the value to set.
   */
  public void setCountry(java.lang.CharSequence value) {
    this.country = value;
  }

  /**
   * Creates a new Movie RecordBuilder.
   * @return A new Movie RecordBuilder
   */
  public static com.kafka.handson.Movie.Builder newBuilder() {
    return new com.kafka.handson.Movie.Builder();
  }

  /**
   * Creates a new Movie RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Movie RecordBuilder
   */
  public static com.kafka.handson.Movie.Builder newBuilder(com.kafka.handson.Movie.Builder other) {
    if (other == null) {
      return new com.kafka.handson.Movie.Builder();
    } else {
      return new com.kafka.handson.Movie.Builder(other);
    }
  }

  /**
   * Creates a new Movie RecordBuilder by copying an existing Movie instance.
   * @param other The existing instance to copy.
   * @return A new Movie RecordBuilder
   */
  public static com.kafka.handson.Movie.Builder newBuilder(com.kafka.handson.Movie other) {
    if (other == null) {
      return new com.kafka.handson.Movie.Builder();
    } else {
      return new com.kafka.handson.Movie.Builder(other);
    }
  }

  /**
   * RecordBuilder for Movie instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Movie>
    implements org.apache.avro.data.RecordBuilder<Movie> {

    private long movie_id;
    private java.lang.CharSequence title;
    private int release_year;
    private java.lang.CharSequence country;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafka.handson.Movie.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.title)) {
        this.title = data().deepCopy(fields()[1].schema(), other.title);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.release_year)) {
        this.release_year = data().deepCopy(fields()[2].schema(), other.release_year);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.country)) {
        this.country = data().deepCopy(fields()[3].schema(), other.country);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing Movie instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafka.handson.Movie other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.title)) {
        this.title = data().deepCopy(fields()[1].schema(), other.title);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.release_year)) {
        this.release_year = data().deepCopy(fields()[2].schema(), other.release_year);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.country)) {
        this.country = data().deepCopy(fields()[3].schema(), other.country);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'movie_id' field.
      * @return The value.
      */
    public long getMovieId() {
      return movie_id;
    }


    /**
      * Sets the value of the 'movie_id' field.
      * @param value The value of 'movie_id'.
      * @return This builder.
      */
    public com.kafka.handson.Movie.Builder setMovieId(long value) {
      validate(fields()[0], value);
      this.movie_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'movie_id' field has been set.
      * @return True if the 'movie_id' field has been set, false otherwise.
      */
    public boolean hasMovieId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'movie_id' field.
      * @return This builder.
      */
    public com.kafka.handson.Movie.Builder clearMovieId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'title' field.
      * @return The value.
      */
    public java.lang.CharSequence getTitle() {
      return title;
    }


    /**
      * Sets the value of the 'title' field.
      * @param value The value of 'title'.
      * @return This builder.
      */
    public com.kafka.handson.Movie.Builder setTitle(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.title = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'title' field has been set.
      * @return True if the 'title' field has been set, false otherwise.
      */
    public boolean hasTitle() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'title' field.
      * @return This builder.
      */
    public com.kafka.handson.Movie.Builder clearTitle() {
      title = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'release_year' field.
      * @return The value.
      */
    public int getReleaseYear() {
      return release_year;
    }


    /**
      * Sets the value of the 'release_year' field.
      * @param value The value of 'release_year'.
      * @return This builder.
      */
    public com.kafka.handson.Movie.Builder setReleaseYear(int value) {
      validate(fields()[2], value);
      this.release_year = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'release_year' field has been set.
      * @return True if the 'release_year' field has been set, false otherwise.
      */
    public boolean hasReleaseYear() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'release_year' field.
      * @return This builder.
      */
    public com.kafka.handson.Movie.Builder clearReleaseYear() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'country' field.
      * @return The value.
      */
    public java.lang.CharSequence getCountry() {
      return country;
    }


    /**
      * Sets the value of the 'country' field.
      * @param value The value of 'country'.
      * @return This builder.
      */
    public com.kafka.handson.Movie.Builder setCountry(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.country = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'country' field has been set.
      * @return True if the 'country' field has been set, false otherwise.
      */
    public boolean hasCountry() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'country' field.
      * @return This builder.
      */
    public com.kafka.handson.Movie.Builder clearCountry() {
      country = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Movie build() {
      try {
        Movie record = new Movie();
        record.movie_id = fieldSetFlags()[0] ? this.movie_id : (java.lang.Long) defaultValue(fields()[0]);
        record.title = fieldSetFlags()[1] ? this.title : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.release_year = fieldSetFlags()[2] ? this.release_year : (java.lang.Integer) defaultValue(fields()[2]);
        record.country = fieldSetFlags()[3] ? this.country : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Movie>
    WRITER$ = (org.apache.avro.io.DatumWriter<Movie>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Movie>
    READER$ = (org.apache.avro.io.DatumReader<Movie>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.movie_id);

    out.writeString(this.title);

    out.writeInt(this.release_year);

    out.writeString(this.country);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.movie_id = in.readLong();

      this.title = in.readString(this.title instanceof Utf8 ? (Utf8)this.title : null);

      this.release_year = in.readInt();

      this.country = in.readString(this.country instanceof Utf8 ? (Utf8)this.country : null);

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.movie_id = in.readLong();
          break;

        case 1:
          this.title = in.readString(this.title instanceof Utf8 ? (Utf8)this.title : null);
          break;

        case 2:
          this.release_year = in.readInt();
          break;

        case 3:
          this.country = in.readString(this.country instanceof Utf8 ? (Utf8)this.country : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










