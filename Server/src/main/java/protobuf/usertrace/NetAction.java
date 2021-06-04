// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserTrace.proto

package protobuf.usertrace;

/**
 * Protobuf type {@code protobuf.usertrace.NetAction}
 */
public final class NetAction extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:protobuf.usertrace.NetAction)
    NetActionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NetAction.newBuilder() to construct.
  private NetAction(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NetAction() {
    netId_ = "";
    actions_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new NetAction();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NetAction(
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
            java.lang.String s = input.readStringRequireUtf8();

            netId_ = s;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              actions_ = new java.util.ArrayList<protobuf.usertrace.Action>();
              mutable_bitField0_ |= 0x00000001;
            }
            actions_.add(
                input.readMessage(protobuf.usertrace.Action.parser(), extensionRegistry));
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
        actions_ = java.util.Collections.unmodifiableList(actions_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return protobuf.usertrace.UserTraceOuterClass.internal_static_protobuf_usertrace_NetAction_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return protobuf.usertrace.UserTraceOuterClass.internal_static_protobuf_usertrace_NetAction_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            protobuf.usertrace.NetAction.class, protobuf.usertrace.NetAction.Builder.class);
  }

  public static final int NETID_FIELD_NUMBER = 1;
  private volatile java.lang.Object netId_;
  /**
   * <code>string netId = 1;</code>
   * @return The netId.
   */
  @java.lang.Override
  public java.lang.String getNetId() {
    java.lang.Object ref = netId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      netId_ = s;
      return s;
    }
  }
  /**
   * <code>string netId = 1;</code>
   * @return The bytes for netId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNetIdBytes() {
    java.lang.Object ref = netId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      netId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ACTIONS_FIELD_NUMBER = 2;
  private java.util.List<protobuf.usertrace.Action> actions_;
  /**
   * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
   */
  @java.lang.Override
  public java.util.List<protobuf.usertrace.Action> getActionsList() {
    return actions_;
  }
  /**
   * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends protobuf.usertrace.ActionOrBuilder> 
      getActionsOrBuilderList() {
    return actions_;
  }
  /**
   * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
   */
  @java.lang.Override
  public int getActionsCount() {
    return actions_.size();
  }
  /**
   * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
   */
  @java.lang.Override
  public protobuf.usertrace.Action getActions(int index) {
    return actions_.get(index);
  }
  /**
   * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
   */
  @java.lang.Override
  public protobuf.usertrace.ActionOrBuilder getActionsOrBuilder(
      int index) {
    return actions_.get(index);
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
    if (!getNetIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, netId_);
    }
    for (int i = 0; i < actions_.size(); i++) {
      output.writeMessage(2, actions_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNetIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, netId_);
    }
    for (int i = 0; i < actions_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, actions_.get(i));
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
    if (!(obj instanceof protobuf.usertrace.NetAction)) {
      return super.equals(obj);
    }
    protobuf.usertrace.NetAction other = (protobuf.usertrace.NetAction) obj;

    if (!getNetId()
        .equals(other.getNetId())) return false;
    if (!getActionsList()
        .equals(other.getActionsList())) return false;
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
    hash = (37 * hash) + NETID_FIELD_NUMBER;
    hash = (53 * hash) + getNetId().hashCode();
    if (getActionsCount() > 0) {
      hash = (37 * hash) + ACTIONS_FIELD_NUMBER;
      hash = (53 * hash) + getActionsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static protobuf.usertrace.NetAction parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.usertrace.NetAction parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.usertrace.NetAction parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.usertrace.NetAction parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.usertrace.NetAction parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static protobuf.usertrace.NetAction parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static protobuf.usertrace.NetAction parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static protobuf.usertrace.NetAction parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static protobuf.usertrace.NetAction parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static protobuf.usertrace.NetAction parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static protobuf.usertrace.NetAction parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static protobuf.usertrace.NetAction parseFrom(
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
  public static Builder newBuilder(protobuf.usertrace.NetAction prototype) {
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
   * Protobuf type {@code protobuf.usertrace.NetAction}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:protobuf.usertrace.NetAction)
      protobuf.usertrace.NetActionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return protobuf.usertrace.UserTraceOuterClass.internal_static_protobuf_usertrace_NetAction_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return protobuf.usertrace.UserTraceOuterClass.internal_static_protobuf_usertrace_NetAction_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              protobuf.usertrace.NetAction.class, protobuf.usertrace.NetAction.Builder.class);
    }

    // Construct using protobuf.usertrace.NetAction.newBuilder()
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
        getActionsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      netId_ = "";

      if (actionsBuilder_ == null) {
        actions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        actionsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return protobuf.usertrace.UserTraceOuterClass.internal_static_protobuf_usertrace_NetAction_descriptor;
    }

    @java.lang.Override
    public protobuf.usertrace.NetAction getDefaultInstanceForType() {
      return protobuf.usertrace.NetAction.getDefaultInstance();
    }

    @java.lang.Override
    public protobuf.usertrace.NetAction build() {
      protobuf.usertrace.NetAction result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public protobuf.usertrace.NetAction buildPartial() {
      protobuf.usertrace.NetAction result = new protobuf.usertrace.NetAction(this);
      int from_bitField0_ = bitField0_;
      result.netId_ = netId_;
      if (actionsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          actions_ = java.util.Collections.unmodifiableList(actions_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.actions_ = actions_;
      } else {
        result.actions_ = actionsBuilder_.build();
      }
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
      if (other instanceof protobuf.usertrace.NetAction) {
        return mergeFrom((protobuf.usertrace.NetAction)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(protobuf.usertrace.NetAction other) {
      if (other == protobuf.usertrace.NetAction.getDefaultInstance()) return this;
      if (!other.getNetId().isEmpty()) {
        netId_ = other.netId_;
        onChanged();
      }
      if (actionsBuilder_ == null) {
        if (!other.actions_.isEmpty()) {
          if (actions_.isEmpty()) {
            actions_ = other.actions_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureActionsIsMutable();
            actions_.addAll(other.actions_);
          }
          onChanged();
        }
      } else {
        if (!other.actions_.isEmpty()) {
          if (actionsBuilder_.isEmpty()) {
            actionsBuilder_.dispose();
            actionsBuilder_ = null;
            actions_ = other.actions_;
            bitField0_ = (bitField0_ & ~0x00000001);
            actionsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getActionsFieldBuilder() : null;
          } else {
            actionsBuilder_.addAllMessages(other.actions_);
          }
        }
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
      protobuf.usertrace.NetAction parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (protobuf.usertrace.NetAction) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object netId_ = "";
    /**
     * <code>string netId = 1;</code>
     * @return The netId.
     */
    public java.lang.String getNetId() {
      java.lang.Object ref = netId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        netId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string netId = 1;</code>
     * @return The bytes for netId.
     */
    public com.google.protobuf.ByteString
        getNetIdBytes() {
      java.lang.Object ref = netId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        netId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string netId = 1;</code>
     * @param value The netId to set.
     * @return This builder for chaining.
     */
    public Builder setNetId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      netId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string netId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNetId() {
      
      netId_ = getDefaultInstance().getNetId();
      onChanged();
      return this;
    }
    /**
     * <code>string netId = 1;</code>
     * @param value The bytes for netId to set.
     * @return This builder for chaining.
     */
    public Builder setNetIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      netId_ = value;
      onChanged();
      return this;
    }

    private java.util.List<protobuf.usertrace.Action> actions_ =
      java.util.Collections.emptyList();
    private void ensureActionsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        actions_ = new java.util.ArrayList<protobuf.usertrace.Action>(actions_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        protobuf.usertrace.Action, protobuf.usertrace.Action.Builder, protobuf.usertrace.ActionOrBuilder> actionsBuilder_;

    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public java.util.List<protobuf.usertrace.Action> getActionsList() {
      if (actionsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(actions_);
      } else {
        return actionsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public int getActionsCount() {
      if (actionsBuilder_ == null) {
        return actions_.size();
      } else {
        return actionsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public protobuf.usertrace.Action getActions(int index) {
      if (actionsBuilder_ == null) {
        return actions_.get(index);
      } else {
        return actionsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public Builder setActions(
        int index, protobuf.usertrace.Action value) {
      if (actionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureActionsIsMutable();
        actions_.set(index, value);
        onChanged();
      } else {
        actionsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public Builder setActions(
        int index, protobuf.usertrace.Action.Builder builderForValue) {
      if (actionsBuilder_ == null) {
        ensureActionsIsMutable();
        actions_.set(index, builderForValue.build());
        onChanged();
      } else {
        actionsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public Builder addActions(protobuf.usertrace.Action value) {
      if (actionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureActionsIsMutable();
        actions_.add(value);
        onChanged();
      } else {
        actionsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public Builder addActions(
        int index, protobuf.usertrace.Action value) {
      if (actionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureActionsIsMutable();
        actions_.add(index, value);
        onChanged();
      } else {
        actionsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public Builder addActions(
        protobuf.usertrace.Action.Builder builderForValue) {
      if (actionsBuilder_ == null) {
        ensureActionsIsMutable();
        actions_.add(builderForValue.build());
        onChanged();
      } else {
        actionsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public Builder addActions(
        int index, protobuf.usertrace.Action.Builder builderForValue) {
      if (actionsBuilder_ == null) {
        ensureActionsIsMutable();
        actions_.add(index, builderForValue.build());
        onChanged();
      } else {
        actionsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public Builder addAllActions(
        java.lang.Iterable<? extends protobuf.usertrace.Action> values) {
      if (actionsBuilder_ == null) {
        ensureActionsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, actions_);
        onChanged();
      } else {
        actionsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public Builder clearActions() {
      if (actionsBuilder_ == null) {
        actions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        actionsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public Builder removeActions(int index) {
      if (actionsBuilder_ == null) {
        ensureActionsIsMutable();
        actions_.remove(index);
        onChanged();
      } else {
        actionsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public protobuf.usertrace.Action.Builder getActionsBuilder(
        int index) {
      return getActionsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public protobuf.usertrace.ActionOrBuilder getActionsOrBuilder(
        int index) {
      if (actionsBuilder_ == null) {
        return actions_.get(index);  } else {
        return actionsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public java.util.List<? extends protobuf.usertrace.ActionOrBuilder> 
         getActionsOrBuilderList() {
      if (actionsBuilder_ != null) {
        return actionsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(actions_);
      }
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public protobuf.usertrace.Action.Builder addActionsBuilder() {
      return getActionsFieldBuilder().addBuilder(
          protobuf.usertrace.Action.getDefaultInstance());
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public protobuf.usertrace.Action.Builder addActionsBuilder(
        int index) {
      return getActionsFieldBuilder().addBuilder(
          index, protobuf.usertrace.Action.getDefaultInstance());
    }
    /**
     * <code>repeated .protobuf.usertrace.Action actions = 2;</code>
     */
    public java.util.List<protobuf.usertrace.Action.Builder> 
         getActionsBuilderList() {
      return getActionsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        protobuf.usertrace.Action, protobuf.usertrace.Action.Builder, protobuf.usertrace.ActionOrBuilder> 
        getActionsFieldBuilder() {
      if (actionsBuilder_ == null) {
        actionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            protobuf.usertrace.Action, protobuf.usertrace.Action.Builder, protobuf.usertrace.ActionOrBuilder>(
                actions_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        actions_ = null;
      }
      return actionsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:protobuf.usertrace.NetAction)
  }

  // @@protoc_insertion_point(class_scope:protobuf.usertrace.NetAction)
  private static final protobuf.usertrace.NetAction DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new protobuf.usertrace.NetAction();
  }

  public static protobuf.usertrace.NetAction getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NetAction>
      PARSER = new com.google.protobuf.AbstractParser<NetAction>() {
    @java.lang.Override
    public NetAction parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NetAction(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NetAction> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NetAction> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public protobuf.usertrace.NetAction getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

