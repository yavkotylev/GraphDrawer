// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Run.proto

package protobuf.run;

/**
 * Protobuf type {@code protobuf.run.TokenMove}
 */
public final class TokenMove extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:protobuf.run.TokenMove)
    TokenMoveOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TokenMove.newBuilder() to construct.
  private TokenMove(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TokenMove() {
    tokenId_ = "";
    placeId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TokenMove();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TokenMove(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            tokenId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            placeId_ = s;
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
    return protobuf.run.RunOuterClass.internal_static_protobuf_run_TokenMove_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return protobuf.run.RunOuterClass.internal_static_protobuf_run_TokenMove_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            protobuf.run.TokenMove.class, protobuf.run.TokenMove.Builder.class);
  }

  public static final int TOKENID_FIELD_NUMBER = 1;
  private volatile java.lang.Object tokenId_;
  /**
   * <code>string tokenId = 1;</code>
   * @return The tokenId.
   */
  @java.lang.Override
  public java.lang.String getTokenId() {
    java.lang.Object ref = tokenId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      tokenId_ = s;
      return s;
    }
  }
  /**
   * <code>string tokenId = 1;</code>
   * @return The bytes for tokenId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTokenIdBytes() {
    java.lang.Object ref = tokenId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      tokenId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PLACEID_FIELD_NUMBER = 2;
  private volatile java.lang.Object placeId_;
  /**
   * <code>string placeId = 2;</code>
   * @return The placeId.
   */
  @java.lang.Override
  public java.lang.String getPlaceId() {
    java.lang.Object ref = placeId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      placeId_ = s;
      return s;
    }
  }
  /**
   * <code>string placeId = 2;</code>
   * @return The bytes for placeId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPlaceIdBytes() {
    java.lang.Object ref = placeId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      placeId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getTokenIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, tokenId_);
    }
    if (!getPlaceIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, placeId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTokenIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, tokenId_);
    }
    if (!getPlaceIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, placeId_);
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
    if (!(obj instanceof protobuf.run.TokenMove)) {
      return super.equals(obj);
    }
    protobuf.run.TokenMove other = (protobuf.run.TokenMove) obj;

    if (!getTokenId()
        .equals(other.getTokenId())) return false;
    if (!getPlaceId()
        .equals(other.getPlaceId())) return false;
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
    hash = (37 * hash) + TOKENID_FIELD_NUMBER;
    hash = (53 * hash) + getTokenId().hashCode();
    hash = (37 * hash) + PLACEID_FIELD_NUMBER;
    hash = (53 * hash) + getPlaceId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static protobuf.run.TokenMove parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.run.TokenMove parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.run.TokenMove parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.run.TokenMove parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.run.TokenMove parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.run.TokenMove parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.run.TokenMove parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static protobuf.run.TokenMove parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static protobuf.run.TokenMove parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static protobuf.run.TokenMove parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static protobuf.run.TokenMove parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static protobuf.run.TokenMove parseFrom(
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
  public static Builder newBuilder(protobuf.run.TokenMove prototype) {
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
   * Protobuf type {@code protobuf.run.TokenMove}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:protobuf.run.TokenMove)
      protobuf.run.TokenMoveOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return protobuf.run.RunOuterClass.internal_static_protobuf_run_TokenMove_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return protobuf.run.RunOuterClass.internal_static_protobuf_run_TokenMove_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              protobuf.run.TokenMove.class, protobuf.run.TokenMove.Builder.class);
    }

    // Construct using protobuf.run.TokenMove.newBuilder()
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
      tokenId_ = "";

      placeId_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return protobuf.run.RunOuterClass.internal_static_protobuf_run_TokenMove_descriptor;
    }

    @java.lang.Override
    public protobuf.run.TokenMove getDefaultInstanceForType() {
      return protobuf.run.TokenMove.getDefaultInstance();
    }

    @java.lang.Override
    public protobuf.run.TokenMove build() {
      protobuf.run.TokenMove result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public protobuf.run.TokenMove buildPartial() {
      protobuf.run.TokenMove result = new protobuf.run.TokenMove(this);
      result.tokenId_ = tokenId_;
      result.placeId_ = placeId_;
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
      if (other instanceof protobuf.run.TokenMove) {
        return mergeFrom((protobuf.run.TokenMove)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(protobuf.run.TokenMove other) {
      if (other == protobuf.run.TokenMove.getDefaultInstance()) return this;
      if (!other.getTokenId().isEmpty()) {
        tokenId_ = other.tokenId_;
        onChanged();
      }
      if (!other.getPlaceId().isEmpty()) {
        placeId_ = other.placeId_;
        onChanged();
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
      protobuf.run.TokenMove parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (protobuf.run.TokenMove) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object tokenId_ = "";
    /**
     * <code>string tokenId = 1;</code>
     * @return The tokenId.
     */
    public java.lang.String getTokenId() {
      java.lang.Object ref = tokenId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        tokenId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string tokenId = 1;</code>
     * @return The bytes for tokenId.
     */
    public com.google.protobuf.ByteString
        getTokenIdBytes() {
      java.lang.Object ref = tokenId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        tokenId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string tokenId = 1;</code>
     * @param value The tokenId to set.
     * @return This builder for chaining.
     */
    public Builder setTokenId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      tokenId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string tokenId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTokenId() {
      
      tokenId_ = getDefaultInstance().getTokenId();
      onChanged();
      return this;
    }
    /**
     * <code>string tokenId = 1;</code>
     * @param value The bytes for tokenId to set.
     * @return This builder for chaining.
     */
    public Builder setTokenIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      tokenId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object placeId_ = "";
    /**
     * <code>string placeId = 2;</code>
     * @return The placeId.
     */
    public java.lang.String getPlaceId() {
      java.lang.Object ref = placeId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        placeId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string placeId = 2;</code>
     * @return The bytes for placeId.
     */
    public com.google.protobuf.ByteString
        getPlaceIdBytes() {
      java.lang.Object ref = placeId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        placeId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string placeId = 2;</code>
     * @param value The placeId to set.
     * @return This builder for chaining.
     */
    public Builder setPlaceId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      placeId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string placeId = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPlaceId() {
      
      placeId_ = getDefaultInstance().getPlaceId();
      onChanged();
      return this;
    }
    /**
     * <code>string placeId = 2;</code>
     * @param value The bytes for placeId to set.
     * @return This builder for chaining.
     */
    public Builder setPlaceIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      placeId_ = value;
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


    // @@protoc_insertion_point(builder_scope:protobuf.run.TokenMove)
  }

  // @@protoc_insertion_point(class_scope:protobuf.run.TokenMove)
  private static final protobuf.run.TokenMove DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new protobuf.run.TokenMove();
  }

  public static protobuf.run.TokenMove getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TokenMove>
      PARSER = new com.google.protobuf.AbstractParser<TokenMove>() {
    @java.lang.Override
    public TokenMove parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TokenMove(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TokenMove> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TokenMove> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public protobuf.run.TokenMove getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

