// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Run.proto

package protobuf.run;

/**
 * Protobuf type {@code protobuf.run.Coordinate}
 */
public final class Coordinate extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:protobuf.run.Coordinate)
    CoordinateOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Coordinate.newBuilder() to construct.
  private Coordinate(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Coordinate() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Coordinate();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Coordinate(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 9: {
            bitField0_ |= 0x00000001;
            x_ = input.readDouble();
            break;
          }
          case 17: {
            bitField0_ |= 0x00000002;
            y_ = input.readDouble();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return protobuf.run.RunOuterClass.internal_static_protobuf_run_Coordinate_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return protobuf.run.RunOuterClass.internal_static_protobuf_run_Coordinate_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            protobuf.run.Coordinate.class, protobuf.run.Coordinate.Builder.class);
  }

  private int bitField0_;
  public static final int X_FIELD_NUMBER = 1;
  private double x_;
  /**
   * <code>double x = 1;</code>
   * @return Whether the x field is set.
   */
  @java.lang.Override
  public boolean hasX() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>double x = 1;</code>
   * @return The x.
   */
  @java.lang.Override
  public double getX() {
    return x_;
  }

  public static final int Y_FIELD_NUMBER = 2;
  private double y_;
  /**
   * <code>double y = 2;</code>
   * @return Whether the y field is set.
   */
  @java.lang.Override
  public boolean hasY() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>double y = 2;</code>
   * @return The y.
   */
  @java.lang.Override
  public double getY() {
    return y_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeDouble(1, x_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeDouble(2, y_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, x_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, y_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof protobuf.run.Coordinate)) {
      return super.equals(obj);
    }
    protobuf.run.Coordinate other = (protobuf.run.Coordinate) obj;

    if (hasX() != other.hasX()) return false;
    if (hasX()) {
      if (java.lang.Double.doubleToLongBits(getX())
          != java.lang.Double.doubleToLongBits(
              other.getX())) return false;
    }
    if (hasY() != other.hasY()) return false;
    if (hasY()) {
      if (java.lang.Double.doubleToLongBits(getY())
          != java.lang.Double.doubleToLongBits(
              other.getY())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasX()) {
      hash = (37 * hash) + X_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          java.lang.Double.doubleToLongBits(getX()));
    }
    if (hasY()) {
      hash = (37 * hash) + Y_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          java.lang.Double.doubleToLongBits(getY()));
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static protobuf.run.Coordinate parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.run.Coordinate parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.run.Coordinate parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.run.Coordinate parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.run.Coordinate parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.run.Coordinate parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.run.Coordinate parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static protobuf.run.Coordinate parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static protobuf.run.Coordinate parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static protobuf.run.Coordinate parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static protobuf.run.Coordinate parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static protobuf.run.Coordinate parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(protobuf.run.Coordinate prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code protobuf.run.Coordinate}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:protobuf.run.Coordinate)
      protobuf.run.CoordinateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return protobuf.run.RunOuterClass.internal_static_protobuf_run_Coordinate_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return protobuf.run.RunOuterClass.internal_static_protobuf_run_Coordinate_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              protobuf.run.Coordinate.class, protobuf.run.Coordinate.Builder.class);
    }

    // Construct using protobuf.run.Coordinate.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      x_ = 0D;
      bitField0_ = (bitField0_ & ~0x00000001);
      y_ = 0D;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return protobuf.run.RunOuterClass.internal_static_protobuf_run_Coordinate_descriptor;
    }

    @java.lang.Override
    public protobuf.run.Coordinate getDefaultInstanceForType() {
      return protobuf.run.Coordinate.getDefaultInstance();
    }

    @java.lang.Override
    public protobuf.run.Coordinate build() {
      protobuf.run.Coordinate result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public protobuf.run.Coordinate buildPartial() {
      protobuf.run.Coordinate result = new protobuf.run.Coordinate(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.x_ = x_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.y_ = y_;
        to_bitField0_ |= 0x00000002;
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof protobuf.run.Coordinate) {
        return mergeFrom((protobuf.run.Coordinate)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(protobuf.run.Coordinate other) {
      if (other == protobuf.run.Coordinate.getDefaultInstance()) return this;
      if (other.hasX()) {
        setX(other.getX());
      }
      if (other.hasY()) {
        setY(other.getY());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      protobuf.run.Coordinate parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (protobuf.run.Coordinate) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private double x_ ;
    /**
     * <code>double x = 1;</code>
     * @return Whether the x field is set.
     */
    @java.lang.Override
    public boolean hasX() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>double x = 1;</code>
     * @return The x.
     */
    @java.lang.Override
    public double getX() {
      return x_;
    }
    /**
     * <code>double x = 1;</code>
     * @param value The x to set.
     * @return This builder for chaining.
     */
    public Builder setX(double value) {
      bitField0_ |= 0x00000001;
      x_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double x = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearX() {
      bitField0_ = (bitField0_ & ~0x00000001);
      x_ = 0D;
      onChanged();
      return this;
    }

    private double y_ ;
    /**
     * <code>double y = 2;</code>
     * @return Whether the y field is set.
     */
    @java.lang.Override
    public boolean hasY() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>double y = 2;</code>
     * @return The y.
     */
    @java.lang.Override
    public double getY() {
      return y_;
    }
    /**
     * <code>double y = 2;</code>
     * @param value The y to set.
     * @return This builder for chaining.
     */
    public Builder setY(double value) {
      bitField0_ |= 0x00000002;
      y_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double y = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearY() {
      bitField0_ = (bitField0_ & ~0x00000002);
      y_ = 0D;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:protobuf.run.Coordinate)
  }

  // @@protoc_insertion_point(class_scope:protobuf.run.Coordinate)
  private static final protobuf.run.Coordinate DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new protobuf.run.Coordinate();
  }

  public static protobuf.run.Coordinate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Coordinate>
      PARSER = new com.google.protobuf.AbstractParser<Coordinate>() {
    @java.lang.Override
    public Coordinate parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Coordinate(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Coordinate> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Coordinate> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public protobuf.run.Coordinate getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

