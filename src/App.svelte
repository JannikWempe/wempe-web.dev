<script>
  import { onMount, onDestroy } from 'svelte'
  import TestComponent from './components/TestComponent.svelte'

  onMount(() => { console.log('Mount  : App.svelte'); console.log('') })
  onDestroy(() => { console.log('Destroy: App.svelte')})
</script>

<div>
  <div class="bg-green-500">App.svelte</div>
  <TestComponent />
</div>
