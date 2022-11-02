import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'image_paths.dart';

final secondPageCountProviderProvider = StateProvider<int>((ref) => 0);

class SecondPage extends StatelessWidget {
  const SecondPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Second page'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Consumer(
              builder: (BuildContext context, WidgetRef ref, Widget? child) {
                final count = ref.watch(secondPageCountProviderProvider);
                return Text('You have visited this page $count times');
              },
            ),
            const SizedBox(height: 16),
            Image.asset(ImagePath.flutter),
          ],
        ),
      ),
    );
  }
}
