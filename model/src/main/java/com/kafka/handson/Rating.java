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
public class Rating extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2108852205140040523L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Rating\",\"namespace\":\"com.kafka.handson\",\"fields\":[{\"name\":\"movie_id\",\"type\":\"long\"},{\"name\":\"rating\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Rating> ENCODER =
      new BinaryMessageEncoder<Rating>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Rating> DECODER =
      new BinaryMessageDecoder<Rating>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Rating> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Rating> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Rating> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Rating>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Rating to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Rating from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Rating instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Rating fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private long movie_id;
  private double rating;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Rating() {}

  /**
   * All-args constructor.
   * @param movie_id The new value for movie_id
   * @param rating The new value for rating
   */
  public Rating(java.lang.Long movie_id, java.lang.Double rating) {
    this.movie_id = movie_id;
    this.rating = rating;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return movie_id;
    case 1: return rating;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: movie_id = (java.lang.Long)value$; break;
    case 1: rating = (java.lang.Double)value$; break;
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
   * Gets the value of the 'rating' field.
   * @return The value of the 'rating' field.
   */
  public double getRating() {
    return rating;
  }


  /**
   * Sets the value of the 'rating' field.
   * @param value the value to set.
   */
  public void setRating(double value) {
    this.rating = value;
  }

  /**
   * Creates a new Rating RecordBuilder.
   * @return A new Rating RecordBuilder
   */
  public static com.kafka.handson.Rating.Builder newBuilder() {
    return new com.kafka.handson.Rating.Builder();
  }

  /**
   * Creates a new Rating RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Rating RecordBuilder
   */
  public static com.kafka.handson.Rating.Builder newBuilder(com.kafka.handson.Rating.Builder other) {
    if (other == null) {
      return new com.kafka.handson.Rating.Builder();
    } else {
      return new com.kafka.handson.Rating.Builder(other);
    }
  }

  /**
   * Creates a new Rating RecordBuilder by copying an existing Rating instance.
   * @param other The existing instance to copy.
   * @return A new Rating RecordBuilder
   */
  public static com.kafka.handson.Rating.Builder newBuilder(com.kafka.handson.Rating other) {
    if (other == null) {
      return new com.kafka.handson.Rating.Builder();
    } else {
      return new com.kafka.handson.Rating.Builder(other);
    }
  }

  /**
   * RecordBuilder for Rating instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Rating>
    implements org.apache.avro.data.RecordBuilder<Rating> {

    private long movie_id;
    private double rating;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.kafka.handson.Rating.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.rating)) {
        this.rating = data().deepCopy(fields()[1].schema(), other.rating);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing Rating instance
     * @param other The existing instance to copy.
     */
    private Builder(com.kafka.handson.Rating other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.rating)) {
        this.rating = data().deepCopy(fields()[1].schema(), other.rating);
        fieldSetFlags()[1] = true;
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
    public com.kafka.handson.Rating.Builder setMovieId(long value) {
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
    public com.kafka.handson.Rating.Builder clearMovieId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'rating' field.
      * @return The value.
      */
    public double getRating() {
      return rating;
    }


    /**
      * Sets the value of the 'rating' field.
      * @param value The value of 'rating'.
      * @return This builder.
      */
    public com.kafka.handson.Rating.Builder setRating(double value) {
      validate(fields()[1], value);
      this.rating = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'rating' field has been set.
      * @return True if the 'rating' field has been set, false otherwise.
      */
    public boolean hasRating() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'rating' field.
      * @return This builder.
      */
    public com.kafka.handson.Rating.Builder clearRating() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Rating build() {
      try {
        Rating record = new Rating();
        record.movie_id = fieldSetFlags()[0] ? this.movie_id : (java.lang.Long) defaultValue(fields()[0]);
        record.rating = fieldSetFlags()[1] ? this.rating : (java.lang.Double) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Rating>
    WRITER$ = (org.apache.avro.io.DatumWriter<Rating>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Rating>
    READER$ = (org.apache.avro.io.DatumReader<Rating>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.movie_id);

    out.writeDouble(this.rating);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.movie_id = in.readLong();

      this.rating = in.readDouble();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.movie_id = in.readLong();
          break;

        case 1:
          this.rating = in.readDouble();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










