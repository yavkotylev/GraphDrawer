// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserNet.proto

package protobuf.usernet;

public interface TransitionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:protobuf.usernet.Transition)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string name = 2;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>double x = 3;</code>
   * @return Whether the x field is set.
   */
  boolean hasX();
  /**
   * <code>double x = 3;</code>
   * @return The x.
   */
  double getX();

  /**
   * <code>double y = 4;</code>
   * @return Whether the y field is set.
   */
  boolean hasY();
  /**
   * <code>double y = 4;</code>
   * @return The y.
   */
  double getY();
}
