// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Run.proto

package protobuf.run;

/**
 * Protobuf type {@code protobuf.run.Run}
 */
public final class Run extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:protobuf.run.Run)
    RunOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Run.newBuilder() to construct.
  private Run(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Run() {
    netActions_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Run();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Run(
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
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              netActions_ = new java.util.ArrayList<protobuf.run.NetAction>();
              mutable_bitField0_ |= 0x00000001;
            }
            netActions_.add(
                input.readMessage(protobuf.run.NetAction.parser(), extensionRegistry));
            break;
          }
          case 18: {
            protobuf.run.Net.Builder subBuilder = null;
            if (net_ != null) {
              subBuilder = net_.toBuilder();
            }
            net_ = input.readMessage(protobuf.run.Net.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(net_);
              net_ = subBuilder.buildPartial();
            }

            break;
          }
          case 24: {
            bitField0_ |= 0x00000001;
            endTime_ = input.readInt64();
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        netActions_ = java.util.Collections.unmodifiableList(netActions_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return protobuf.run.RunOuterClass.internal_static_protobuf_run_Run_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return protobuf.run.RunOuterClass.internal_static_protobuf_run_Run_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            protobuf.run.Run.class, protobuf.run.Run.Builder.class);
  }

  private int bitField0_;
  public static final int NETACTIONS_FIELD_NUMBER = 1;
  private java.util.List<protobuf.run.NetAction> netActions_;
  /**
   * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
   */
  @java.lang.Override
  public java.util.List<protobuf.run.NetAction> getNetActionsList() {
    return netActions_;
  }
  /**
   * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends protobuf.run.NetActionOrBuilder> 
      getNetActionsOrBuilderList() {
    return netActions_;
  }
  /**
   * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
   */
  @java.lang.Override
  public int getNetActionsCount() {
    return netActions_.size();
  }
  /**
   * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
   */
  @java.lang.Override
  public protobuf.run.NetAction getNetActions(int index) {
    return netActions_.get(index);
  }
  /**
   * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
   */
  @java.lang.Override
  public protobuf.run.NetActionOrBuilder getNetActionsOrBuilder(
      int index) {
    return netActions_.get(index);
  }

  public static final int NET_FIELD_NUMBER = 2;
  private protobuf.run.Net net_;
  /**
   * <code>.protobuf.run.Net net = 2;</code>
   * @return Whether the net field is set.
   */
  @java.lang.Override
  public boolean hasNet() {
    return net_ != null;
  }
  /**
   * <code>.protobuf.run.Net net = 2;</code>
   * @return The net.
   */
  @java.lang.Override
  public protobuf.run.Net getNet() {
    return net_ == null ? protobuf.run.Net.getDefaultInstance() : net_;
  }
  /**
   * <code>.protobuf.run.Net net = 2;</code>
   */
  @java.lang.Override
  public protobuf.run.NetOrBuilder getNetOrBuilder() {
    return getNet();
  }

  public static final int ENDTIME_FIELD_NUMBER = 3;
  private long endTime_;
  /**
   * <code>int64 endTime = 3;</code>
   * @return Whether the endTime field is set.
   */
  @java.lang.Override
  public boolean hasEndTime() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>int64 endTime = 3;</code>
   * @return The endTime.
   */
  @java.lang.Override
  public long getEndTime() {
    return endTime_;
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
    for (int i = 0; i < netActions_.size(); i++) {
      output.writeMessage(1, netActions_.get(i));
    }
    if (net_ != null) {
      output.writeMessage(2, getNet());
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeInt64(3, endTime_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < netActions_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, netActions_.get(i));
    }
    if (net_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getNet());
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, endTime_);
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
    if (!(obj instanceof protobuf.run.Run)) {
      return super.equals(obj);
    }
    protobuf.run.Run other = (protobuf.run.Run) obj;

    if (!getNetActionsList()
        .equals(other.getNetActionsList())) return false;
    if (hasNet() != other.hasNet()) return false;
    if (hasNet()) {
      if (!getNet()
          .equals(other.getNet())) return false;
    }
    if (hasEndTime() != other.hasEndTime()) return false;
    if (hasEndTime()) {
      if (getEndTime()
          != other.getEndTime()) return false;
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
    if (getNetActionsCount() > 0) {
      hash = (37 * hash) + NETACTIONS_FIELD_NUMBER;
      hash = (53 * hash) + getNetActionsList().hashCode();
    }
    if (hasNet()) {
      hash = (37 * hash) + NET_FIELD_NUMBER;
      hash = (53 * hash) + getNet().hashCode();
    }
    if (hasEndTime()) {
      hash = (37 * hash) + ENDTIME_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getEndTime());
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static protobuf.run.Run parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.run.Run parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.run.Run parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.run.Run parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.run.Run parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.run.Run parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.run.Run parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static protobuf.run.Run parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static protobuf.run.Run parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static protobuf.run.Run parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static protobuf.run.Run parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static protobuf.run.Run parseFrom(
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
  public static Builder newBuilder(protobuf.run.Run prototype) {
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
   * Protobuf type {@code protobuf.run.Run}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:protobuf.run.Run)
      protobuf.run.RunOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return protobuf.run.RunOuterClass.internal_static_protobuf_run_Run_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return protobuf.run.RunOuterClass.internal_static_protobuf_run_Run_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              protobuf.run.Run.class, protobuf.run.Run.Builder.class);
    }

    // Construct using protobuf.run.Run.newBuilder()
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
        getNetActionsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (netActionsBuilder_ == null) {
        netActions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        netActionsBuilder_.clear();
      }
      if (netBuilder_ == null) {
        net_ = null;
      } else {
        net_ = null;
        netBuilder_ = null;
      }
      endTime_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return protobuf.run.RunOuterClass.internal_static_protobuf_run_Run_descriptor;
    }

    @java.lang.Override
    public protobuf.run.Run getDefaultInstanceForType() {
      return protobuf.run.Run.getDefaultInstance();
    }

    @java.lang.Override
    public protobuf.run.Run build() {
      protobuf.run.Run result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public protobuf.run.Run buildPartial() {
      protobuf.run.Run result = new protobuf.run.Run(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (netActionsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          netActions_ = java.util.Collections.unmodifiableList(netActions_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.netActions_ = netActions_;
      } else {
        result.netActions_ = netActionsBuilder_.build();
      }
      if (netBuilder_ == null) {
        result.net_ = net_;
      } else {
        result.net_ = netBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.endTime_ = endTime_;
        to_bitField0_ |= 0x00000001;
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
      if (other instanceof protobuf.run.Run) {
        return mergeFrom((protobuf.run.Run)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(protobuf.run.Run other) {
      if (other == protobuf.run.Run.getDefaultInstance()) return this;
      if (netActionsBuilder_ == null) {
        if (!other.netActions_.isEmpty()) {
          if (netActions_.isEmpty()) {
            netActions_ = other.netActions_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureNetActionsIsMutable();
            netActions_.addAll(other.netActions_);
          }
          onChanged();
        }
      } else {
        if (!other.netActions_.isEmpty()) {
          if (netActionsBuilder_.isEmpty()) {
            netActionsBuilder_.dispose();
            netActionsBuilder_ = null;
            netActions_ = other.netActions_;
            bitField0_ = (bitField0_ & ~0x00000001);
            netActionsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getNetActionsFieldBuilder() : null;
          } else {
            netActionsBuilder_.addAllMessages(other.netActions_);
          }
        }
      }
      if (other.hasNet()) {
        mergeNet(other.getNet());
      }
      if (other.hasEndTime()) {
        setEndTime(other.getEndTime());
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
      protobuf.run.Run parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (protobuf.run.Run) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<protobuf.run.NetAction> netActions_ =
      java.util.Collections.emptyList();
    private void ensureNetActionsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        netActions_ = new java.util.ArrayList<protobuf.run.NetAction>(netActions_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        protobuf.run.NetAction, protobuf.run.NetAction.Builder, protobuf.run.NetActionOrBuilder> netActionsBuilder_;

    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public java.util.List<protobuf.run.NetAction> getNetActionsList() {
      if (netActionsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(netActions_);
      } else {
        return netActionsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public int getNetActionsCount() {
      if (netActionsBuilder_ == null) {
        return netActions_.size();
      } else {
        return netActionsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public protobuf.run.NetAction getNetActions(int index) {
      if (netActionsBuilder_ == null) {
        return netActions_.get(index);
      } else {
        return netActionsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public Builder setNetActions(
        int index, protobuf.run.NetAction value) {
      if (netActionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNetActionsIsMutable();
        netActions_.set(index, value);
        onChanged();
      } else {
        netActionsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public Builder setNetActions(
        int index, protobuf.run.NetAction.Builder builderForValue) {
      if (netActionsBuilder_ == null) {
        ensureNetActionsIsMutable();
        netActions_.set(index, builderForValue.build());
        onChanged();
      } else {
        netActionsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public Builder addNetActions(protobuf.run.NetAction value) {
      if (netActionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNetActionsIsMutable();
        netActions_.add(value);
        onChanged();
      } else {
        netActionsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public Builder addNetActions(
        int index, protobuf.run.NetAction value) {
      if (netActionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNetActionsIsMutable();
        netActions_.add(index, value);
        onChanged();
      } else {
        netActionsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public Builder addNetActions(
        protobuf.run.NetAction.Builder builderForValue) {
      if (netActionsBuilder_ == null) {
        ensureNetActionsIsMutable();
        netActions_.add(builderForValue.build());
        onChanged();
      } else {
        netActionsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public Builder addNetActions(
        int index, protobuf.run.NetAction.Builder builderForValue) {
      if (netActionsBuilder_ == null) {
        ensureNetActionsIsMutable();
        netActions_.add(index, builderForValue.build());
        onChanged();
      } else {
        netActionsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public Builder addAllNetActions(
        java.lang.Iterable<? extends protobuf.run.NetAction> values) {
      if (netActionsBuilder_ == null) {
        ensureNetActionsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, netActions_);
        onChanged();
      } else {
        netActionsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public Builder clearNetActions() {
      if (netActionsBuilder_ == null) {
        netActions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        netActionsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public Builder removeNetActions(int index) {
      if (netActionsBuilder_ == null) {
        ensureNetActionsIsMutable();
        netActions_.remove(index);
        onChanged();
      } else {
        netActionsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public protobuf.run.NetAction.Builder getNetActionsBuilder(
        int index) {
      return getNetActionsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public protobuf.run.NetActionOrBuilder getNetActionsOrBuilder(
        int index) {
      if (netActionsBuilder_ == null) {
        return netActions_.get(index);  } else {
        return netActionsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public java.util.List<? extends protobuf.run.NetActionOrBuilder> 
         getNetActionsOrBuilderList() {
      if (netActionsBuilder_ != null) {
        return netActionsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(netActions_);
      }
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public protobuf.run.NetAction.Builder addNetActionsBuilder() {
      return getNetActionsFieldBuilder().addBuilder(
          protobuf.run.NetAction.getDefaultInstance());
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public protobuf.run.NetAction.Builder addNetActionsBuilder(
        int index) {
      return getNetActionsFieldBuilder().addBuilder(
          index, protobuf.run.NetAction.getDefaultInstance());
    }
    /**
     * <code>repeated .protobuf.run.NetAction netActions = 1;</code>
     */
    public java.util.List<protobuf.run.NetAction.Builder> 
         getNetActionsBuilderList() {
      return getNetActionsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        protobuf.run.NetAction, protobuf.run.NetAction.Builder, protobuf.run.NetActionOrBuilder> 
        getNetActionsFieldBuilder() {
      if (netActionsBuilder_ == null) {
        netActionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            protobuf.run.NetAction, protobuf.run.NetAction.Builder, protobuf.run.NetActionOrBuilder>(
                netActions_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        netActions_ = null;
      }
      return netActionsBuilder_;
    }

    private protobuf.run.Net net_;
    private com.google.protobuf.SingleFieldBuilderV3<
        protobuf.run.Net, protobuf.run.Net.Builder, protobuf.run.NetOrBuilder> netBuilder_;
    /**
     * <code>.protobuf.run.Net net = 2;</code>
     * @return Whether the net field is set.
     */
    public boolean hasNet() {
      return netBuilder_ != null || net_ != null;
    }
    /**
     * <code>.protobuf.run.Net net = 2;</code>
     * @return The net.
     */
    public protobuf.run.Net getNet() {
      if (netBuilder_ == null) {
        return net_ == null ? protobuf.run.Net.getDefaultInstance() : net_;
      } else {
        return netBuilder_.getMessage();
      }
    }
    /**
     * <code>.protobuf.run.Net net = 2;</code>
     */
    public Builder setNet(protobuf.run.Net value) {
      if (netBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        net_ = value;
        onChanged();
      } else {
        netBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.protobuf.run.Net net = 2;</code>
     */
    public Builder setNet(
        protobuf.run.Net.Builder builderForValue) {
      if (netBuilder_ == null) {
        net_ = builderForValue.build();
        onChanged();
      } else {
        netBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.protobuf.run.Net net = 2;</code>
     */
    public Builder mergeNet(protobuf.run.Net value) {
      if (netBuilder_ == null) {
        if (net_ != null) {
          net_ =
            protobuf.run.Net.newBuilder(net_).mergeFrom(value).buildPartial();
        } else {
          net_ = value;
        }
        onChanged();
      } else {
        netBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.protobuf.run.Net net = 2;</code>
     */
    public Builder clearNet() {
      if (netBuilder_ == null) {
        net_ = null;
        onChanged();
      } else {
        net_ = null;
        netBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.protobuf.run.Net net = 2;</code>
     */
    public protobuf.run.Net.Builder getNetBuilder() {
      
      onChanged();
      return getNetFieldBuilder().getBuilder();
    }
    /**
     * <code>.protobuf.run.Net net = 2;</code>
     */
    public protobuf.run.NetOrBuilder getNetOrBuilder() {
      if (netBuilder_ != null) {
        return netBuilder_.getMessageOrBuilder();
      } else {
        return net_ == null ?
            protobuf.run.Net.getDefaultInstance() : net_;
      }
    }
    /**
     * <code>.protobuf.run.Net net = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        protobuf.run.Net, protobuf.run.Net.Builder, protobuf.run.NetOrBuilder> 
        getNetFieldBuilder() {
      if (netBuilder_ == null) {
        netBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            protobuf.run.Net, protobuf.run.Net.Builder, protobuf.run.NetOrBuilder>(
                getNet(),
                getParentForChildren(),
                isClean());
        net_ = null;
      }
      return netBuilder_;
    }

    private long endTime_ ;
    /**
     * <code>int64 endTime = 3;</code>
     * @return Whether the endTime field is set.
     */
    @java.lang.Override
    public boolean hasEndTime() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>int64 endTime = 3;</code>
     * @return The endTime.
     */
    @java.lang.Override
    public long getEndTime() {
      return endTime_;
    }
    /**
     * <code>int64 endTime = 3;</code>
     * @param value The endTime to set.
     * @return This builder for chaining.
     */
    public Builder setEndTime(long value) {
      bitField0_ |= 0x00000002;
      endTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 endTime = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearEndTime() {
      bitField0_ = (bitField0_ & ~0x00000002);
      endTime_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:protobuf.run.Run)
  }

  // @@protoc_insertion_point(class_scope:protobuf.run.Run)
  private static final protobuf.run.Run DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new protobuf.run.Run();
  }

  public static protobuf.run.Run getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Run>
      PARSER = new com.google.protobuf.AbstractParser<Run>() {
    @java.lang.Override
    public Run parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Run(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Run> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Run> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public protobuf.run.Run getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

