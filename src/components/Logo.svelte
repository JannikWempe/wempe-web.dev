<script>
  import {onMount} from "svelte";

  const MID_LEFT_EYE_CX_POS = 63
  const MID_RIGHT_EYE_CX_POS = 98
  const MAX_CX_POS_DIFF = 5

  const MID_CY_POS = 38.5
  const MAX_CY_POS_DIFF = 6.5

  let mouseX, mouseY
  let innerHeight, innerWidth

  let leftEye, rightEye
  let initialLeftEyeX, initialRightEyeX, initialEyesY
  let leftEyeCx = MID_LEFT_EYE_CX_POS
  let rightEyeCx = MID_RIGHT_EYE_CX_POS
  let eyesCy = MID_CY_POS

  onMount(() => {
    const {x: lX, y} = leftEye.getBoundingClientRect()
    initialLeftEyeX = lX
    const {x: rX} = rightEye.getBoundingClientRect()
    initialRightEyeX = rX
    initialEyesY = y
  })

  const handleMousemove = (e) => {
    mouseX = e.clientX
    mouseY = e.clientY

    handleEyeX('left', mouseX)
    handleEyeX('right', mouseX)
    handleEyesY(mouseY)
  }

  const handleEyeX = (eye, mouseX) => {
    const isLeft = eye.toLowerCase() === "left"
    const eyeInitialsXPos = isLeft ? initialLeftEyeX : initialRightEyeX

    const rightWidth = innerWidth - eyeInitialsXPos
    const leftWidth = innerWidth - (innerWidth - eyeInitialsXPos)

    const isMouseRight = mouseX > leftWidth
    const mouseDistancePercent =  isMouseRight ? ((mouseX - leftWidth) / rightWidth) : 1 - (mouseX / leftWidth)
    const diffX = isMouseRight ? mouseDistancePercent * MAX_CX_POS_DIFF : mouseDistancePercent * MAX_CX_POS_DIFF * (-1)

    if (isLeft) {
      leftEyeCx = MID_LEFT_EYE_CX_POS + diffX
    } else {
      rightEyeCx = MID_RIGHT_EYE_CX_POS + diffX
    }
  }

  const handleEyesY = (mouseY) => {
    const bottomHeight = innerHeight - initialEyesY
    const topHeight = innerHeight - (innerHeight - initialEyesY)

    const isMouseBottom = mouseY > topHeight
    const mouseDistancePercent =  isMouseBottom ? ((mouseY - topHeight) / bottomHeight) : 1 - (mouseY / topHeight)
    const diffY = isMouseBottom ? mouseDistancePercent * MAX_CY_POS_DIFF : mouseDistancePercent * MAX_CY_POS_DIFF * (-1)
    eyesCy = MID_CY_POS + diffY
  }
</script>

<svelte:window bind:innerHeight={innerHeight} bind:innerWidth={innerWidth} />
<svelte:body on:mousemove={handleMousemove} />
<svg class="{$$restProps.class || ''} fill-current" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 161 76" fill="currentColor" stroke-linecap="round" stroke-linejoin="round">
  <g fill="#8B5CF6">
    <!-- nose -->
    <circle cx="80.5" cy="52" r="3" />
    <!-- eyes -->
    <g>
      <circle bind:this={leftEye} cx="{leftEyeCx}" cy="{eyesCy}" r="3"/>
      <circle bind:this={rightEye} cx="{rightEyeCx}" cy="{eyesCy}" r="3"/>
    </g>
    <g>
<!--      <rect x="53" y="28" width="20" height="21"/>-->
<!--      <rect x="88" y="28" width="20" height="21"/>-->
    </g>
  </g>
  <!-- glasses -->
  <g fill="transparent" stroke="#2563eb" stroke-width="4" >
    <path d="M64.228 2s-4.915 3.988-7.373 8.475c-.844 1.54-1.893 19.115-1.893 19.115M53 49.953l.577-3.862m0 0S74 58.613 74 38.835c0-19.777-19.038-9.245-19.038-9.245m-1.385 16.5l1.385-16.5" />
    <path d="M96.772 2s4.915 3.988 7.373 8.475c.844 1.54 1.893 19.115 1.893 19.115M108 49.953l-.577-3.862m0 0S87 58.613 87 38.835c0-19.777 19.038-9.245 19.038-9.245m1.385 16.5l-1.385-16.5" />
    <path d="M74 35s2-2 6.5-2 6.5 2 6.5 2"/>
  </g>
  <!-- text -->
  <g fill="transparent" stroke="currentColor" stroke-width="3" >
    <!-- mouth -->
    <path stroke="#8B5CF6" stroke-width="4" d="M58 60s7.059 14 22.5 14C95.941 74 103 60 103 60" />
    <!-- w -->
    <path d="M2 27l5 23 5.5-10.5L18 50l4-23"/>
    <!-- 1st e -->
    <path d="M27.029 39.812h19.679s2.81-12.585-8.996-12.585c-11.808 0-10.683 12.585-10.683 12.585zm0 0s0 10.415 10.683 10.415c0 0 4.497 0 8.995-2.603"/>
    <!-- 2nd e -->
    <path d="M133.971 39.953h-19.678s-2.812-12.585 8.996-12.585c11.807 0 10.682 12.585 10.682 12.585zm0 0s0 10.415-10.683 10.415c0 0-4.497 0-8.995-2.603"/>
    <!-- v -->
    <path d="M139 27.227l10 23 10-23"/>
  </g>
</svg>
