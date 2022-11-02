

import 'package:flutter/material.dart';

extension BuildContextX on BuildContext {
  void pop<T>([T? result]) => Navigator.pop(this, result);

  Future<T?> push<T>(Widget widget, {bool fullscreenDialog = false}) =>
      Navigator.push<T>(
          this,
          MaterialPageRoute(
              builder: (context) => widget,
              fullscreenDialog: fullscreenDialog));
}
