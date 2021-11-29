package com.jantosovic.dss;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Thank you kind stranger of stackoverflow for this tree visualization class
 * https://stackoverflow.com/a/19484210
 * @param <T>
 */
final class Node<T extends Comparable<T>> {
  T value;
  Node<T> left, right;

  public Node<T> insertToTree(T v) {
    if (value == null) {
      value = v;
      return this;
    }
    if (v.compareTo(value) < 0) {
      if (left == null) {
        left = new Node<T>();
      }
      return left.insertToTree(v);
    } else {
      if (right == null) {
        right = new Node<T>();
      }
      return right.insertToTree(v);
    }
  }

  public void printTree(OutputStream out) throws IOException {
    var writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
    if (right != null) {
      right.printTree(writer, true, "");
    }
    printNodeValue(writer);
    if (left != null) {
      left.printTree(writer, false, "");
    }
    writer.close();
  }

  private void printNodeValue(OutputStreamWriter out) throws IOException {
    if (value == null) {
      out.write("<null>");
    } else {
      out.write(value.toString());
    }
    out.write('\n');
  }

  // use string and not stringbuffer on purpose as we need to change the indent at each recursion
  private void printTree(OutputStreamWriter out, boolean isRight, String indent) throws IOException {
    if (right != null) {
      right.printTree(out, true, indent + (isRight ? "        " : " |      "));
    }
    out.write(indent);
    if (isRight) {
      out.write(" /");
    } else {
      out.write(" \\");
    }
    out.write("----- ");
    printNodeValue(out);
    if (left != null) {
      left.printTree(out, false, indent + (isRight ? " |      " : "        "));
    }
  }

}
