// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GrpcServer.proto

package io.grpc;

/**
 * Protobuf type {@code io.grpc.NewNodeResponse}
 */
public  final class NewNodeResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.grpc.NewNodeResponse)
    NewNodeResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NewNodeResponse.newBuilder() to construct.
  private NewNodeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NewNodeResponse() {
    fingerT_ = "";
    update_ = false;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NewNodeResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
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
            String s = input.readStringRequireUtf8();

            fingerT_ = s;
            break;
          }
          case 16: {

            update_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
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
    return ServerProto.internal_static_io_grpc_NewNodeResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ServerProto.internal_static_io_grpc_NewNodeResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            NewNodeResponse.class, Builder.class);
  }

  public static final int FINGERT_FIELD_NUMBER = 1;
  private volatile Object fingerT_;
  /**
   * <code>string fingerT = 1;</code>
   */
  public String getFingerT() {
    Object ref = fingerT_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      fingerT_ = s;
      return s;
    }
  }
  /**
   * <code>string fingerT = 1;</code>
   */
  public com.google.protobuf.ByteString
      getFingerTBytes() {
    Object ref = fingerT_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      fingerT_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int UPDATE_FIELD_NUMBER = 2;
  private boolean update_;
  /**
   * <code>bool update = 2;</code>
   */
  public boolean getUpdate() {
    return update_;
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getFingerTBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, fingerT_);
    }
    if (update_ != false) {
      output.writeBool(2, update_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getFingerTBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, fingerT_);
    }
    if (update_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, update_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof NewNodeResponse)) {
      return super.equals(obj);
    }
    NewNodeResponse other = (NewNodeResponse) obj;

    boolean result = true;
    result = result && getFingerT()
        .equals(other.getFingerT());
    result = result && (getUpdate()
        == other.getUpdate());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + FINGERT_FIELD_NUMBER;
    hash = (53 * hash) + getFingerT().hashCode();
    hash = (37 * hash) + UPDATE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getUpdate());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static NewNodeResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NewNodeResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NewNodeResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NewNodeResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NewNodeResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static NewNodeResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static NewNodeResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NewNodeResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static NewNodeResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static NewNodeResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static NewNodeResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static NewNodeResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(NewNodeResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code io.grpc.NewNodeResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.grpc.NewNodeResponse)
      NewNodeResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ServerProto.internal_static_io_grpc_NewNodeResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ServerProto.internal_static_io_grpc_NewNodeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              NewNodeResponse.class, Builder.class);
    }

    // Construct using io.grpc.NewNodeResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      fingerT_ = "";

      update_ = false;

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ServerProto.internal_static_io_grpc_NewNodeResponse_descriptor;
    }

    @Override
    public NewNodeResponse getDefaultInstanceForType() {
      return NewNodeResponse.getDefaultInstance();
    }

    @Override
    public NewNodeResponse build() {
      NewNodeResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public NewNodeResponse buildPartial() {
      NewNodeResponse result = new NewNodeResponse(this);
      result.fingerT_ = fingerT_;
      result.update_ = update_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof NewNodeResponse) {
        return mergeFrom((NewNodeResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(NewNodeResponse other) {
      if (other == NewNodeResponse.getDefaultInstance()) return this;
      if (!other.getFingerT().isEmpty()) {
        fingerT_ = other.fingerT_;
        onChanged();
      }
      if (other.getUpdate() != false) {
        setUpdate(other.getUpdate());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      NewNodeResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (NewNodeResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object fingerT_ = "";
    /**
     * <code>string fingerT = 1;</code>
     */
    public String getFingerT() {
      Object ref = fingerT_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        fingerT_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string fingerT = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFingerTBytes() {
      Object ref = fingerT_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        fingerT_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string fingerT = 1;</code>
     */
    public Builder setFingerT(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      fingerT_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string fingerT = 1;</code>
     */
    public Builder clearFingerT() {
      
      fingerT_ = getDefaultInstance().getFingerT();
      onChanged();
      return this;
    }
    /**
     * <code>string fingerT = 1;</code>
     */
    public Builder setFingerTBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      fingerT_ = value;
      onChanged();
      return this;
    }

    private boolean update_ ;
    /**
     * <code>bool update = 2;</code>
     */
    public boolean getUpdate() {
      return update_;
    }
    /**
     * <code>bool update = 2;</code>
     */
    public Builder setUpdate(boolean value) {
      
      update_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool update = 2;</code>
     */
    public Builder clearUpdate() {
      
      update_ = false;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:io.grpc.NewNodeResponse)
  }

  // @@protoc_insertion_point(class_scope:io.grpc.NewNodeResponse)
  private static final NewNodeResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new NewNodeResponse();
  }

  public static NewNodeResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NewNodeResponse>
      PARSER = new com.google.protobuf.AbstractParser<NewNodeResponse>() {
    @Override
    public NewNodeResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NewNodeResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NewNodeResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<NewNodeResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public NewNodeResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

