import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:savannah_demo/context_extension.dart';
import 'package:savannah_demo/image_paths.dart';

import 'kotlin_page_count_provider.dart';
import 'method_channel_helper.dart';
import 'second_page.dart';

class HomePage extends ConsumerWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final secondPageCountNotifier =
        ref.watch(secondPageCountProviderProvider.notifier);
    final kotlinPageCountNotifier = ref.watch(kotlinPageCountProvider.notifier);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Main page'),
      ),
      body: Center(
        child: InkWell(
          onLongPress: () {
            kotlinPageCountNotifier.state++;
            final counts = <int>[
              kotlinPageCountNotifier.state,
              secondPageCountNotifier.state,
              kotlinPageCountNotifier.state + secondPageCountNotifier.state
            ];
            MethodChannelHelper.openKotlin(counts);
          },
          onTap: () {
            secondPageCountNotifier.state++;
            context.push(const SecondPage());
          },
          child: Image.asset(ImagePath.main),
        ),
      ),
    );
  }
}
