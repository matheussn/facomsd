// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: helloworld.proto

package io.grpc;

public interface GetResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:helloworld.GetResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string status = 1;</code>
   */
  String getStatus();
  /**
   * <code>string status = 1;</code>
   */
  com.google.protobuf.ByteString
      getStatusBytes();

  /**
   * <code>string message = 2;</code>
   */
  String getMessage();
  /**
   * <code>string message = 2;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>string data = 3;</code>
   */
  String getData();
  /**
   * <code>string data = 3;</code>
   */
  com.google.protobuf.ByteString
      getDataBytes();
}
