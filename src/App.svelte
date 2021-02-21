<script>
  import { onMount, onDestroy } from 'svelte'
  import TestComponent from './components/TestComponent.svelte'

  onMount(() => { console.log('Mount  : App.svelte'); console.log('') })
  onDestroy(() => { console.log('Destroy: App.svelte')})
</script>

<div>
  App.svelte
  <TestComponent />
</div>

<style>
  div { background-color: lime; }
</style>
