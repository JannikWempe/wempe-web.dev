<script>
  import { onMount, onDestroy } from 'svelte'
  onMount(() => { console.log('mount  : TestComponent.svelte') })
  onDestroy(() => { console.log('destroy: TestComponent.svelte')})
</script>

<div class="test-component">
  TestComponent.svelte
</div>

<style>
  div { background-color: aqua; }
</style>
