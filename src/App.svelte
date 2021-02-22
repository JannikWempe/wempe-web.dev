<script>
  import Logo from "./components/Logo.svelte";
  import Xing from "./components/Social/Xing.svelte";
  import LinkedIn from "./components/Social/LinkedIn.svelte";
  import GitHub from "./components/Social/GitHub.svelte";
  import Twitter from "./components/Social/Twitter.svelte";
</script>

<div class="p-8 bg-gray-100 rounded-xl shadow-lg">
  <Logo class="mx-auto h-32" />
  <div class="mt-5 text-center font-semibold">
    <h1 class="text-3xl bg-clip-text text-transparent bg-gradient-to-b from-blue-600 to-purple-500">Jannik Wempe</h1>
    <h2 class="text-xl text-purple-500">Full Stack Web Developer</h2>
  </div>
  <div class="mt-12 flex justify-around">
    <Xing class="block h-8 w-8 transition duration-500 ease-in-out transform hover:scale-110"/>
    <LinkedIn class="block h-8 w-8 transition duration-500 ease-in-out transform hover:scale-110"/>
    <GitHub class="block h-8 w-8 transition duration-500 ease-in-out transform hover:scale-110"/>
    <Twitter class="block h-8 w-8 transition duration-500 ease-in-out transform hover:scale-110"/>
  </div>
</div>
