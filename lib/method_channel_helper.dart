import 'package:flutter/services.dart';

class MethodChannelHelper {
  static const MethodChannel _channel = MethodChannel('native_channel');

  static Future<void> openKotlin(List<int> counts) async {
    await _channel.invokeMethod('open_kotlin', counts);
  }
}
